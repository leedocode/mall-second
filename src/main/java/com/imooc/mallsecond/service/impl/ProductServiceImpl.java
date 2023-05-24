package com.imooc.mallsecond.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mallsecond.dao.ProductMapper;
import com.imooc.mallsecond.pojo.Product;
import com.imooc.mallsecond.service.ICategoryService;
import com.imooc.mallsecond.service.IProductService;
import com.imooc.mallsecond.vo.ProductVo;
import com.imooc.mallsecond.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述: TODO
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();
        if (categoryId != null) {
            categoryService.findSubCategoryId(categoryId, categoryIdSet);
            categoryIdSet.add(categoryId);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productMapper.selectByCategoryIdSet(categoryIdSet);
        List<ProductVo> productVoList = new ArrayList<>();
        for (Product product : products) {
            ProductVo productVo = new ProductVo();
            BeanUtils.copyProperties(product, productVo);
            productVoList.add(productVo);
        }
        PageInfo pageInfo = new PageInfo(products);
        pageInfo.setList(productVoList);
        return ResponseVo.success(pageInfo);
    }
}
