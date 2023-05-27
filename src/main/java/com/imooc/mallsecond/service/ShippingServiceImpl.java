package com.imooc.mallsecond.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mallsecond.dao.ShippingMapper;
import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.form.ShippingForm;
import com.imooc.mallsecond.pojo.Shipping;
import com.imooc.mallsecond.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: TODO
 */

@Service
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;


    @Override
    public ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm shippingForm) {
        Shipping shipping = new Shipping();
        shipping.setUserId(uid);
        BeanUtils.copyProperties(shippingForm, shipping);
        int row = shippingMapper.insertSelective(shipping);
        if (row == 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("shippingId", shipping.getId());
        return ResponseVo.success(map);
    }

    @Override
    public ResponseVo delete(Integer uid, Integer shippingId) {
        return null;
    }

    @Override
    public ResponseVo update(Integer uid, Integer shippingId, ShippingForm shippingForm) {
        return null;
    }

    @Override
    public ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize) {
        return null;
    }
}
