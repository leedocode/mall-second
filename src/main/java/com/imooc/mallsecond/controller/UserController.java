package com.imooc.mallsecond.controller;

import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.form.UserForm;
import com.imooc.mallsecond.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/register")
    public ResponseVo<?> register(@Valid @RequestBody UserForm userForm, BindingResult bindResult) {


        if (bindResult.hasErrors()) {
            log.error("注册提交的参数有误, {} {}",
                    bindResult.getFieldError().getField(),
                    bindResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(ResponseEnum.PARAM_ERROR,bindResult);

        }
        log.info("username={}",userForm.getUsername());


        //return ResponseVo.success();
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }
}
