package com.hh.layuidemo;

import com.hh.layuidemo.entity.User;
import com.hh.layuidemo.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LayuidemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void getUserTest(){
        User userInfo = userService.getUserInfo("15760467978");
        System.out.println(userInfo);
    }

}
