package com.imooc.mallsecond.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mallsecond.form.ShippingForm;
import com.imooc.mallsecond.vo.ResponseVo;

import java.util.Map;

public interface IShippingService {

    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm shippingForm);

    ResponseVo delete(Integer uid, Integer shippingId);

    ResponseVo update(Integer uid, Integer shippingId, ShippingForm shippingForm);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);
}
