package com.hh.layuidemo.controller;

import com.hh.layuidemo.service.impl.ProductServiceimpl;
import com.hh.layuidemo.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceimpl productServiceimpl;
    @RequestMapping("/list")
    public DataVO data(Integer page,Integer limit){ //这里是layui来掉会带上这两个参数给你
        DataVO dataList=productServiceimpl.findData(page,limit);
        return dataList;
    }
}
