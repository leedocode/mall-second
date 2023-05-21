package com.imooc.mallsecond.service;

import com.imooc.mallsecond.vo.ProductVo;
import com.imooc.mallsecond.vo.ResponseVo;

import java.util.List;

public interface IProductService {
    ResponseVo<List<ProductVo>> list(Integer categoryId, Integer pageNum, Integer pageSize);
}
