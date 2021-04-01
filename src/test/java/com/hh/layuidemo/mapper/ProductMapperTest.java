package com.hh.layuidemo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;
    @Test
    public void test1(){
        productMapper.selectList(null).forEach(System.out::println);
    }
}