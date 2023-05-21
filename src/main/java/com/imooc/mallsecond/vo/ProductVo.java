package com.imooc.mallsecond.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述: TODO
 */
@Data
public class ProductVo {
    private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private String mainImage;

    private Integer status;

    private BigDecimal price;
}
