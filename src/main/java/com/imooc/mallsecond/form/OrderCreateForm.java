package com.imooc.mallsecond.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 描述: TODO
 */

@Data
public class OrderCreateForm {

    @NotNull
    private Integer shippingId;
}
