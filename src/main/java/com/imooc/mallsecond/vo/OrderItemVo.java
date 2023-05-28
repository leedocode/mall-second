package com.imooc.mallsecond.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述: TODO
 */

@Data
public class OrderItemVo {

    private Long orderNo;

    private Integer productId;

    private String productName;

    private String productImage;

    private BigDecimal currentUnitPrice;

    private Integer quantity;

    private BigDecimal totalPrice;

    private Date createTime;

}
