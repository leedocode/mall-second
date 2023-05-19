package com.imooc.mallsecond.vo;

import lombok.Data;

import java.util.List;

/**
 * 描述: TODO
 */
@Data
public class CategoryVo {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;
}
