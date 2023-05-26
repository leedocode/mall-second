package com.imooc.mallsecond.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 描述: 添加商品
 */
@Data
public class CartAddForm {

    @NotNull
    private Integer productId;

    private Boolean selected = true;

}
