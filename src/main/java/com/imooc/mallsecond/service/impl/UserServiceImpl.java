package com.imooc.mallsecond.service.impl;

import com.imooc.mallsecond.dao.UserMapper;
import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.enums.RoleEnum;
import com.imooc.mallsecond.pojo.User;
import com.imooc.mallsecond.service.IUserService;
import com.imooc.mallsecond.vo.ResponseVo;
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
    public ResponseVo<?> register(User user) {

        user.setRole(RoleEnum.CUSTOMER.getCode());
        //username 不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0) {
            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }

        //email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 0) {
            return ResponseVo.error(ResponseEnum.EMAIL_EXIST);
        }

        //MD5摘要算法
        String s = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
        user.setPassword(s);
        //写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        return ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            //用户不存在
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        if (!user.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))) {
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        return ResponseVo.success(user);
    }
}
