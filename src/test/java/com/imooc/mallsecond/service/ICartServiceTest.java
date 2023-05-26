package com.imooc.mallsecond.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mallsecond.MallSecondApplicationTests;
import com.imooc.mallsecond.form.CartAddForm;
import com.imooc.mallsecond.vo.CartVo;
import com.imooc.mallsecond.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ICartServiceTest extends MallSecondApplicationTests {

    @Autowired
    ICartService cartService;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void addTest() {
        CartAddForm form = new CartAddForm();
        form.setProductId(27);
        form.setSelected(true);
        ResponseVo<CartVo> add = cartService.add(1, form);
        log.info("add={}",gson.toJson(add));
    }

    @Test
    public void listTest() {
        ResponseVo<CartVo> responseVo = cartService.list(1);
        log.info("list={}", gson.toJson(responseVo));
    }

}