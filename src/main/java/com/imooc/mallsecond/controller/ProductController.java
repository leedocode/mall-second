package com.imooc.mallsecond.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.mallsecond.service.IProductService;
import com.imooc.mallsecond.vo.ProductDetailVo;
import com.imooc.mallsecond.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: TODO
 */
@RestController
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public ResponseVo<PageInfo> list(@RequestParam(required = false) Integer categoryId,
                                     @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return productService.list(categoryId, pageNum, pageSize);
    }

    @GetMapping("/products/{productId}")
    public ResponseVo<ProductDetailVo> detail(@PathVariable Integer productId) {
        return productService.detail(productId);
    }
}
