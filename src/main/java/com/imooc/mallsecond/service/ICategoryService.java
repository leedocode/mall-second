package com.imooc.mallsecond.service;

import com.imooc.mallsecond.vo.CategoryVo;
import com.imooc.mallsecond.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface ICategoryService {

    ResponseVo<List<CategoryVo>> listForCustomer();
    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
