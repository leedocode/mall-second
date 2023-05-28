package com.imooc.mallsecond.enums;


import lombok.Getter;

@Getter
public enum PaymentTypeEnum {

    PAY_ONLINE(1),
    ;

    private int code;

    PaymentTypeEnum(int code) {
        this.code = code;
    }
}
