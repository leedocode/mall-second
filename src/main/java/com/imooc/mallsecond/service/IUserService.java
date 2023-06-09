package com.imooc.mallsecond.service;

import com.imooc.mallsecond.pojo.User;
import com.imooc.mallsecond.vo.ResponseVo;

public interface IUserService {

    //注册
    ResponseVo register(User user);

    //登录】
    ResponseVo<User> login(String username, String password);
}
