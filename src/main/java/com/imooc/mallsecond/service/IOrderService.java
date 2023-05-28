package com.imooc.mallsecond.service;

import com.imooc.mallsecond.vo.OrderVo;
import com.imooc.mallsecond.vo.ResponseVo;

public interface IOrderService {

    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);

}
