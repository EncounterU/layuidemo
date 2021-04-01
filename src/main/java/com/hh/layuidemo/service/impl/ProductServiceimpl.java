package com.hh.layuidemo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hh.layuidemo.entity.Product;
import com.hh.layuidemo.mapper.ProductMapper;
import com.hh.layuidemo.service.ProductServie;
import com.hh.layuidemo.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceimpl implements ProductServie {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public DataVO<Product> findData(Integer page,Integer limit) {
        DataVO dataVO=new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(productMapper.selectCount(null));
        //dataVO.setData(productMapper.selectList(null));
        //创建一个分页条件对象
        IPage<Product> productIPage=new Page<>(page,limit);
        //用这个分页条件去查询数据
        IPage<Product> productList= productMapper.selectPage(productIPage,null);
        //然后通过 getRecords()取出查询中的数据（上面这个productList除了数据还可以有其他东西）
        List<Product> records = productList.getRecords();
        dataVO.setData(records);
        return dataVO;
    }
}
