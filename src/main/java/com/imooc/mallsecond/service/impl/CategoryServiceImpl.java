package com.imooc.mallsecond.service.impl;

import com.imooc.mallsecond.consts.MallConst;
import com.imooc.mallsecond.dao.CategoryMapper;
import com.imooc.mallsecond.pojo.Category;
import com.imooc.mallsecond.service.ICategoryService;
import com.imooc.mallsecond.vo.CategoryVo;
import com.imooc.mallsecond.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 描述: TODO
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public ResponseVo<List<CategoryVo>> listForCustomer() {

        List<CategoryVo> categoryVoList = new ArrayList<>();
        List<Category> categories = categoryMapper.selectAll();

        //查出parentId=0的数据，也即根目录的数据
        for (Category category : categories) {
            if (category.getParentId().equals(MallConst.ROOT_PARENT_ID)) {
                CategoryVo categoryVo = category2CategoryVo(category);
                categoryVoList.add(categoryVo);
            }
        }
        categoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
        findSubCategory(categoryVoList, categories);
        return ResponseVo.success(categoryVoList);
    }

    private void findSubCategory(List<CategoryVo> categoryVoList, List<Category> categories) {

        if (!CollectionUtils.isEmpty(categoryVoList)) {
            for (CategoryVo categoryVo : categoryVoList) {
                List<CategoryVo> subCategories = new ArrayList<>();
                for (Category c : categories) {
                    if (c.getParentId().equals(categoryVo.getId())) {
                        CategoryVo e = category2CategoryVo(c);
                        subCategories.add(e);
                    }
                }
                subCategories.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
                categoryVo.setSubCategories(subCategories);
                findSubCategory(categoryVo.getSubCategories(), categories);
            }
        }

    }

    private CategoryVo category2CategoryVo(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }
}
