package com.imooc.mallsecond.service;

import com.imooc.mallsecond.form.CartAddForm;
import com.imooc.mallsecond.vo.CartVo;
import com.imooc.mallsecond.vo.ResponseVo;

public interface ICartService {

    ResponseVo<CartVo> add(Integer uid, CartAddForm cartAddForm);

    ResponseVo<CartVo> list(Integer uid);
}