package com.imooc.mallsecond.service.impl;

import com.imooc.mallsecond.dao.UserMapper;
import com.imooc.mallsecond.pojo.User;
import com.imooc.mallsecond.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * 描述: TODO
 */

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    UserMapper userMapper;
    @Override
    public void register(User user) {

        //username 不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0) {
            throw new RuntimeException("该username已注册");
        }

        //email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 0) {
            throw new RuntimeException("该email已注册");
        }

        //MD5摘要算法
        String s = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
        user.setPassword(s);
        //写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0) {
            throw new RuntimeException("注册失败");
        }

    }
}
