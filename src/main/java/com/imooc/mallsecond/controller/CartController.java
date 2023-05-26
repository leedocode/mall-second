package com.imooc.mallsecond.controller;

import com.imooc.mallsecond.form.CartAddForm;
import com.imooc.mallsecond.vo.CartVo;
import com.imooc.mallsecond.vo.ResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 描述: TODO
 */

@RestController
public class CartController {

    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@Valid @RequestBody CartAddForm cartAddForm) {
        return null;
    }
}
