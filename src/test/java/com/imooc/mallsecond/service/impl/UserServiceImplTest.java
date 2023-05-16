package com.imooc.mallsecond.service.impl;

import com.imooc.mallsecond.MallSecondApplicationTests;
import com.imooc.mallsecond.enums.RoleEnum;
import com.imooc.mallsecond.pojo.User;
import com.imooc.mallsecond.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

//增加事务注解，没有提交的话以下写入操作会自动回滚，不会对数据库进行写入
@Transactional
public class UserServiceImplTest extends MallSecondApplicationTests {

    @Autowired
    private IUserService userService;
    @Test
    public void register() {
        User user = new User("jack", "123456", "jack@qq.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }
}