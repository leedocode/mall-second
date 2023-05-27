package com.imooc.mallsecond.service;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mallsecond.MallSecondApplicationTests;
import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.form.ShippingForm;
import com.imooc.mallsecond.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.Assert.*;

@Slf4j
public class IShippingServiceTest extends MallSecondApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid = 2;
    private Integer shippingId = 5;

    private ShippingForm shippingForm;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @Before
    public void before() {
        ShippingForm shippingForm = new ShippingForm();
        shippingForm.setReceiverName("李炜捷4");
        shippingForm.setReceiverAddress("北交大2");
        shippingForm.setReceiverCity("北京1");
        shippingForm.setReceiverMobile("13225969670");
        shippingForm.setReceiverPhone("12345678");
        shippingForm.setReceiverProvince("北京2");
        shippingForm.setReceiverDistrict("海淀区");
        shippingForm.setReceiverZip("000000");
        this.shippingForm = shippingForm;
    }
    @Test
    public void add() {

        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, shippingForm);
        log.info("responseVo={}",responseVo);
    }

    @Test
    public void delete() {
        ResponseVo responseVo = shippingService.delete(uid, shippingId);
        log.info("responseVo={}", responseVo);
    }

    @Test
    public void update() {
        shippingForm.setReceiverCity("天津");
        ResponseVo responseVo = shippingService.update(uid, shippingId, shippingForm);
        log.info("responseVo={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo<PageInfo> list = shippingService.list(2, 2, 1);
        log.info("list={}",gson.toJson(list));
    }
}