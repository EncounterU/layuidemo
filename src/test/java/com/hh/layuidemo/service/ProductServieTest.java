package com.hh.layuidemo.service;

import com.hh.layuidemo.service.impl.ProductServiceimpl;
import com.hh.layuidemo.vo.DataVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServieTest {
    @Autowired
    private ProductServiceimpl productServiceimpl;

    @Test
    void findData() {
        DataVO dataVO=productServiceimpl.findData(1,10);
        int i=0;
    }
}