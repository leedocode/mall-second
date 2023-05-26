package com.imooc.mallsecond.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mallsecond.vo.ProductDetailVo;
import com.imooc.mallsecond.vo.ResponseVo;

public interface IProductService {
    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
