package com.imooc.mallsecond;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mallsecond.dao")
public class MallSecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSecondApplication.class, args);
    }

}
