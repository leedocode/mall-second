package com.imooc.mallsecond.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mallsecond.MallSecondApplicationTests;
import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.service.ICartService;
import com.imooc.mallsecond.service.IOrderService;
import com.imooc.mallsecond.vo.OrderVo;
import com.imooc.mallsecond.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class OrderServiceImplTest extends MallSecondApplicationTests {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ICartService cartService;

    private Integer uid = 1;

    private Integer shippingId = 4;

    private Integer productId = 26;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

//    @Before
//    public void addCart() {
//        CartAddForm form = new CartAddForm();
//        form.setProductId(productId);
//        form.setSelected(true);
//        ResponseVo<CartVo> add = cartService.add(1, form);
//        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), add.getStatus());
//    }

    @Test
    public void create() {
        ResponseVo<OrderVo> orderVoResponseVo = orderService.create(uid, shippingId);
        log.info("orderVoResponseVo={}", gson.toJson(orderVoResponseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), orderVoResponseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo<PageInfo> list = orderService.list(uid, 1, 10);
        log.info("orderVoResponseVo={}", gson.toJson(list));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), list.getStatus());
    }
}