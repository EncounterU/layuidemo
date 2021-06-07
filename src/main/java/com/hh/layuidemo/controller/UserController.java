package com.hh.layuidemo.controller;

import com.hh.layuidemo.entity.DataInfo;
import com.hh.layuidemo.entity.User;
import com.hh.layuidemo.service.impl.UserService;
import com.hh.layuidemo.service.impl.impl.UserServiceImpl;
import com.hh.layuidemo.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HostHolder hostHolder;
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo(String phone){
        User user = hostHolder.getUser();
        User userInfo = userService.getUserInfo(user.getPhone());
        System.out.println(userInfo);
        return userInfo;
    }
    @RequestMapping("/login")
    @ResponseBody
    public DataInfo verLogin(HttpServletRequest request,HttpServletResponse response){
        DataInfo dataInfo=new DataInfo();
        String phone =request.getParameter("phone");
        String password =request.getParameter("password");
        int userCount = userService.isUser(phone);
        User user = userService.getUserInfo(phone);
        if(userCount==0){
            dataInfo.setData(null);
            dataInfo.setCode(-1);
            dataInfo.setMsg("你还没有注册，请先注册!");
            return dataInfo;
        }
        else {
            String pwd=user.getPassword();
            if(!password.equals(pwd)){
                dataInfo.setData(null);
                dataInfo.setCode(0);
                dataInfo.setMsg("密码错误");
                return dataInfo;
            }
        }
        Cookie cookie=new Cookie("phone",phone);
        response.addCookie(cookie);
        dataInfo.setData(user);
        dataInfo.setCode(1);
        dataInfo.setMsg("登录成功");
        return dataInfo;
    }
}
