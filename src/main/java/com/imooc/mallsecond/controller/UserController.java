package com.imooc.mallsecond.controller;

import com.imooc.mallsecond.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: TODO
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        log.info("username={}",user.getUsername());
    }
}
