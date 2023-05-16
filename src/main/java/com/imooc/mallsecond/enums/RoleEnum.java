package com.imooc.mallsecond.enums;


import lombok.Getter;

@Getter
public enum RoleEnum {

    ADMIN(0),
    CUSTOMER(1);


    Integer code;

    RoleEnum(Integer code) {
        this.code = code;
    }
}
