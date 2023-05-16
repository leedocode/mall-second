package com.imooc.mallsecond.controller;

import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.form.UserForm;
import com.imooc.mallsecond.pojo.User;
import com.imooc.mallsecond.service.IUserService;
import com.imooc.mallsecond.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 描述: TODO
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/register")
    public ResponseVo<?> register(@Valid @RequestBody UserForm userForm, BindingResult bindResult) {

        if (bindResult.hasErrors()) {
            log.error("注册提交的参数有误, {} {}",
                    bindResult.getFieldError().getField(),
                    bindResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(ResponseEnum.PARAM_ERROR,bindResult);

        }

        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return userService.register(user);

    }
}
