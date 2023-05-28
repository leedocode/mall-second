package com.imooc.mallsecond.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

    CANCELED(0, "已取消"),
    NO_PAY(10, "未能付款"),
    PAID(20, "已付款"),
    SHIPPED(40, "已发货"),
    TRADE_SUCCESS(50, "交易成功"),
    TRADE_CLOSE(60, "交易关闭"),
    ;

    private int code;

    private String desc;

    OrderStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
