package com.imooc.mallsecond.service;

import com.imooc.mallsecond.MallSecondApplicationTests;
import com.imooc.mallsecond.form.ShippingForm;
import com.imooc.mallsecond.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.Assert.*;

@Slf4j
public class ShippingServiceImplTest extends MallSecondApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid = 1;
    @Test
    public void add() {
        ShippingForm shippingForm = new ShippingForm();
        shippingForm.setReceiverName("李炜捷2");
        shippingForm.setReceiverAddress("北交大");
        shippingForm.setReceiverCity("北京");
        shippingForm.setReceiverMobile("13225969670");
        shippingForm.setReceiverPhone("12345678");
        shippingForm.setReceiverProvince("北京");
        shippingForm.setReceiverDistrict("海淀区");
        shippingForm.setReceiverZip("000000");
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, shippingForm);
        log.info("responseVo={}",responseVo);
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void list() {
    }
}