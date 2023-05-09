package com.imooc.mallsecond;

import com.imooc.mallsecond.dao.CategoryMapper;
import com.imooc.mallsecond.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallSecondApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void testCategoryMapper() {
        Category category = categoryMapper.findById(100001);
        System.out.println(category.toString());
    }

    @Test
    public void testQueryById() {
        Category category = categoryMapper.queryById(100001);
        System.out.println(category.toString());
    }

}
