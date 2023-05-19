package com.imooc.mallsecond.service;

import com.imooc.mallsecond.vo.CategoryVo;
import com.imooc.mallsecond.vo.ResponseVo;

import java.util.List;

public interface ICategoryService {

    ResponseVo<List<CategoryVo>> listForCustomer();
}
