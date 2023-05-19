package com.imooc.mallsecond.service;

import com.imooc.mallsecond.MallSecondApplicationTests;
import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.vo.CategoryVo;
import com.imooc.mallsecond.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;
public class ICategoryServiceTest extends MallSecondApplicationTests {

    @Autowired
    ICategoryService categoryService;

    @Test
    public void testSelectAll() {
        ResponseVo<List<CategoryVo>> responseVo = categoryService.listForCustomer();
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

}