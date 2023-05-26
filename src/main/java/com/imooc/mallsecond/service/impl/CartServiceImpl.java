package com.imooc.mallsecond.service.impl;

import com.google.gson.Gson;
import com.imooc.mallsecond.dao.ProductMapper;
import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.form.CartAddForm;
import com.imooc.mallsecond.pojo.Cart;
import com.imooc.mallsecond.pojo.Product;
import com.imooc.mallsecond.service.ICartService;
import com.imooc.mallsecond.vo.CartProductVo;
import com.imooc.mallsecond.vo.CartVo;
import com.imooc.mallsecond.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * 描述: TODO
 */
@Service
public class CartServiceImpl implements ICartService {

    public static final String CART_REDIS_KEY_TEMPLATE = "cart_%d";
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private Gson gson = new Gson();

    @Override
    public ResponseVo<CartVo> add(Integer uid, CartAddForm cartAddForm) {

        Integer quantity = 1;
        Product product = productMapper.selectByPrimaryKey(cartAddForm.getProductId());
        //商品是否存在
        if (product == null) {
            return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST);
        }
        //商品是否正常在售
        if (product.getStock() <= 0) {
            return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR);
        }

        //写入Redis，将商品固定不变的数据写入redis，为什么要写入redis？
        //建立一个hash列表
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uid);
        String value = opsForHash.get(redisKey, String.valueOf(product.getId()));

        Cart cart;
        if (StringUtils.isEmpty(value)) {
            //没有该商品
            cart = new Cart(product.getId(), quantity, cartAddForm.getSelected());
        } else {
            //有该商品,进行数量加1的操作
            //对json数据反序列化为原始对象
            cart = gson.fromJson(value, Cart.class);
            cart.setQuantity(cart.getQuantity() + quantity);


        }

        opsForHash
        .put(redisKey,
                String.valueOf(product.getId()),
                gson.toJson(cart)); //redis要求键值对都要是字符串，因此这里需要序列化


        return list(1);
    }

    @Override
    public ResponseVo<CartVo> list(Integer uid) {

        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uid);
        Map<String, String> entries = opsForHash.entries(redisKey);
        CartVo cartVo = new CartVo();
        List<CartProductVo> cartVoList = new ArrayList<>();
        boolean selectAll = true;
        Integer cartTotalQuantity = 0;
        BigDecimal cartTotalPrice = new BigDecimal("0");

        // 使用一个set,存入所有redis中出现的商品id，然后通过mysql in 关键字 一次查出所有商品相关的数据
        Set<Integer> productIdSet = new HashSet<>();
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            Integer productId = Integer.valueOf(entry.getKey());
            productIdSet.add(productId);
        }
        List<Product> products = productMapper.selectByProductIdSet(productIdSet);
        //使用map方便后续对相应product的获取
        Map<Integer, Product> productMap = new HashMap<>();
        for (Product product : products) {
            productMap.put(product.getId(), product);
        }


        for (Map.Entry<String, String> entry : entries.entrySet()) {
            Integer productId = Integer.valueOf(entry.getKey());
            Cart cart = gson.fromJson(entry.getValue(), Cart.class);
            Product product = productMap.get(productId);
            if (product != null) {
                CartProductVo cartProductVo = new CartProductVo(
                        productId,
                        cart.getQuantity(),
                        product.getName(),
                        product.getSubtitle(),
                        product.getMainImage(),
                        product.getPrice(),
                        product.getStatus(),
                        product.getCategoryId(),
                        product.getPrice().multiply(BigDecimal.valueOf(cart.getQuantity())),
                        product.getStock(),
                        cart.getProductSelected()
                );
                cartVoList.add(cartProductVo);


                if (!cart.getProductSelected()) {
                    selectAll = false;
                }

                //计算总价，只计算选中的
                if (cart.getProductSelected()) {
                    cartTotalPrice = cartTotalPrice.add(cartProductVo.getProductTotalPrice());
                }
            }
            cartTotalQuantity += cart.getQuantity();

        }
        cartVo.setCartProductVoList(cartVoList);
        //有一个没有选中，就不叫全选
        cartVo.setSelectedAll(selectAll);
        cartVo.setCartTotalQuantity(cartTotalQuantity);
        cartVo.setCartTotalPrice(cartTotalPrice);

        return ResponseVo.success(cartVo);

    }
}
