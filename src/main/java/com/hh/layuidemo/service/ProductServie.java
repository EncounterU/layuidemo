package com.hh.layuidemo.service;

import com.hh.layuidemo.entity.Product;
import com.hh.layuidemo.vo.DataVO;
import org.springframework.stereotype.Service;

@Service
public interface ProductServie {
    public DataVO<Product> findData(Integer page,Integer limit);
}
