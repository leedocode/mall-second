package com.imooc.mallsecond.service;

import com.imooc.mallsecond.MallSecondApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IProductServiceTest extends MallSecondApplicationTests {

    @Autowired
    IProductService productService;

    @Test
    public void listTest() {
        //ResponseVo<List<ProductVo>> responseVo = productService.list(null, 1, 2);
        //Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

}