package com.imooc.mallsecond.listener;

import com.google.gson.Gson;
import com.imooc.mallsecond.pojo.PayInfo;
import com.imooc.mallsecond.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述: TODO
 */
@Component
@RabbitListener(queues = "payNotify")
@Slf4j
public class PayMsgListener {

    @Autowired
    IOrderService orderService;

    @RabbitHandler
    public void process(String msg) {
        log.info("[接收到消息] => {}", msg);
        PayInfo payInfo = new Gson().fromJson(msg, PayInfo.class);
        if (payInfo.getPlatformStatus().equals("SUCCESS")) {
            orderService.paid(payInfo.getOrderNo());
        }
    }
}
