package com.imooc.mallsecond.controller;

import com.imooc.mallsecond.consts.MallConst;
import com.imooc.mallsecond.form.UserLoginForm;
import com.imooc.mallsecond.form.UserRegisterForm;
import com.imooc.mallsecond.pojo.User;
import com.imooc.mallsecond.service.IUserService;
import com.imooc.mallsecond.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 描述: TODO
 */

@RestController
@Slf4j
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/user/register")
    public ResponseVo<?> register(@Valid @RequestBody UserRegisterForm userRegisterForm) {

        User user = new User();
        BeanUtils.copyProperties(userRegisterForm, user);
        return userService.register(user);

    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                               HttpSession session) {
        //对请求中参数的检验放到了统一异常处理中
        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        session.setAttribute(MallConst.CURRENT_USER, userResponseVo.getData());
        return userResponseVo;
    }

    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session) {
        log.info("/user sessionId={}", session.getId());
        User user = (User)session.getAttribute(MallConst.CURRENT_USER);
//        if (user == null) {
//            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
//        }
        return ResponseVo.success(user);
    }

    @GetMapping("/user/logout")
    public ResponseVo logout(HttpSession session) {
        log.info("/user/logout sessionId = {}", session.getId());
//        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
//        if (user == null) {
//            return ResponseVo.error(ResponseEnum.ERROR);
//        }
        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.successForMsg("退出成功");
    }


}
