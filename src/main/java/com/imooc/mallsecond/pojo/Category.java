package com.imooc.mallsecond.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 描述: TODO
 */

@Data
public class Category {
    private Integer id;

    private Integer parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

}
