package com.hh.layuidemo.service.impl;

import com.hh.layuidemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     public User getUserInfo(String phone);
     public int isUser(String phone);
}
