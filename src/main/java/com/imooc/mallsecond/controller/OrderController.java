package com.imooc.mallsecond.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.mallsecond.consts.MallConst;
import com.imooc.mallsecond.form.OrderCreateForm;
import com.imooc.mallsecond.pojo.User;
import com.imooc.mallsecond.service.IOrderService;
import com.imooc.mallsecond.vo.OrderVo;
import com.imooc.mallsecond.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 描述: TODO
 */
@RestController
public class OrderController {

    @Autowired
    IOrderService orderService;

    @PostMapping("/orders")
    public ResponseVo<OrderVo> create(@Valid @RequestBody OrderCreateForm form, HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.create(user.getId(), form.getShippingId());
    }

    @GetMapping("/orders")
    public ResponseVo<PageInfo> list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer pageSize, HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.list(user.getId(), pageNum, pageSize);
    }

    @GetMapping("/orders/{orderNo}")
    public ResponseVo<OrderVo> detail(@PathVariable Long orderNo, HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.detail(user.getId(), orderNo);
    }

    @PutMapping("/orders/{orderNo}")
    public ResponseVo cancel(@PathVariable Long orderNo, HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.cancel(user.getId(), orderNo);
    }



}
