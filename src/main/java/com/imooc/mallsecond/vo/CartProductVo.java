package com.imooc.mallsecond.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述: TODO
 */

@Data
public class CartProductVo {

    private Integer productId;

    //购买数量
    private Integer quantity;

    private String productName;

    private String productSubtitle;

    private String productMainImage;

    private BigDecimal productPrice;

    private Integer productStatus;
    private Integer categoryId;

    private BigDecimal productTotalPrice;

    private Integer productStock;

    private Boolean productSelected;

    public CartProductVo(Integer productId, Integer quantity, String productName, String productSubtitle, String productMainImage, BigDecimal productPrice, Integer productStatus, Integer categoryId, BigDecimal productTotalPrice, Integer productStock, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.productSubtitle = productSubtitle;
        this.productMainImage = productMainImage;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.categoryId = categoryId;
        this.productTotalPrice = productTotalPrice;
        this.productStock = productStock;
        this.productSelected = productSelected;
    }
}
