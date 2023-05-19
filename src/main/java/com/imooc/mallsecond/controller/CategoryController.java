package com.imooc.mallsecond.controller;

import com.imooc.mallsecond.service.ICategoryService;
import com.imooc.mallsecond.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: TODO
 */
@RestController
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseVo listForCustomer() {
        return categoryService.listForCustomer();
    }
}
