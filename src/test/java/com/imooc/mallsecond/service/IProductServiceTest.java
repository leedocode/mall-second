package com.imooc.mallsecond.service;

import com.imooc.mallsecond.MallSecondApplicationTests;
import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.vo.ProductDetailVo;
import com.imooc.mallsecond.vo.ResponseVo;
import org.junit.Assert;
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

    @Test
    public void detailTest() {
        ResponseVo<ProductDetailVo> responseVo = productService.detail(26);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

}