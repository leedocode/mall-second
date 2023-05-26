package com.imooc.mallsecond.dao;

import com.imooc.mallsecond.MallSecondApplicationTests;
import com.imooc.mallsecond.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class ProductMapperTest extends MallSecondApplicationTests {


    @Autowired
    ProductMapper productMapper;
    @Test
    public void selectByProductIdSet() {
        Set<Integer> set = new HashSet<>();
        set.add(26);
        set.add(27);
        set.add(28);
        List<Product> products = productMapper.selectByProductIdSet(set);
        log.info("products={}", products);
    }
}