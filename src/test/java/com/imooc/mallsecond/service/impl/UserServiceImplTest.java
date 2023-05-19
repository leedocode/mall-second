package com.imooc.mallsecond.service.impl;

import com.imooc.mallsecond.MallSecondApplicationTests;
import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.enums.RoleEnum;
import com.imooc.mallsecond.pojo.User;
import com.imooc.mallsecond.service.ICategoryService;
import com.imooc.mallsecond.service.IUserService;
import com.imooc.mallsecond.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

//增加事务注解，没有提交的话以下写入操作会自动回滚，不会对数据库进行写入
@Transactional
public class UserServiceImplTest extends MallSecondApplicationTests {

    public static final String USERNAME = "aaaa";
    public static final String PASSWORD = "aaaa";
    public static final String EMAIL = "aaaa@qq.com";

    @Autowired
    private IUserService userService;

    @Autowired
    private ICategoryService categoryService;

    @Before
    public void registerTest() {
        User user = new User(USERNAME, PASSWORD, EMAIL, RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }

    @Test
    public void loginTest() {
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}