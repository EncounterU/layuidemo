package com.hh.layuidemo.service.impl.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hh.layuidemo.entity.User;
import com.hh.layuidemo.mapper.UserMapper;
import com.hh.layuidemo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserInfo(String phone) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("phone",phone);
        List<User> user=userMapper.selectList(queryWrapper);
        return user;
    }

    @Override
    public int isUser(String phone) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("phone",phone);
        Integer integer = userMapper.selectCount(queryWrapper);
        return integer;
    }
}
