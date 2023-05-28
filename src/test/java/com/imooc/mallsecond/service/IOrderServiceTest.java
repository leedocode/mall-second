package com.imooc.mallsecond.service;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mallsecond.MallSecondApplicationTests;
import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.form.CartAddForm;
import com.imooc.mallsecond.vo.CartVo;
import com.imooc.mallsecond.vo.OrderVo;
import com.imooc.mallsecond.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
public class IOrderServiceTest extends MallSecondApplicationTests {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ICartService cartService;

    private Integer uid = 1;

    private Integer shippingId = 4;

    private Integer productId = 26;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Before
    public void addCart() {
        CartAddForm form = new CartAddForm();
        form.setProductId(productId);
        form.setSelected(true);
        ResponseVo<CartVo> add = cartService.add(1, form);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), add.getStatus());
    }


    public ResponseVo<OrderVo> create() {
        ResponseVo<OrderVo> orderVoResponseVo = orderService.create(uid, shippingId);
        log.info("orderVoResponseVo={}", gson.toJson(orderVoResponseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), orderVoResponseVo.getStatus());
        return orderVoResponseVo;
    }

    @Test
    public void list() {
        ResponseVo<PageInfo> list = orderService.list(uid, 1, 10);
        log.info("orderVoResponseVo={}", gson.toJson(list));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), list.getStatus());
    }

    @Test
    public void detail() {
        ResponseVo<OrderVo> orderVoResponseVo = create();
        ResponseVo<OrderVo> detail = orderService.detail(uid, orderVoResponseVo.getData().getOrderNo());
        log.info("result={}", gson.toJson(orderVoResponseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), orderVoResponseVo.getStatus());
    }

    @Test
    public void cancel() {
        ResponseVo<OrderVo> orderVoResponseVo = create();
        ResponseVo cancel = orderService.cancel(uid, orderVoResponseVo.getData().getOrderNo());
        log.info("cancel={}",gson.toJson(cancel));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), cancel.getStatus());
    }
}