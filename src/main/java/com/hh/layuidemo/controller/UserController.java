package com.hh.layuidemo.controller;

import com.hh.layuidemo.entity.DataInfo;
import com.hh.layuidemo.entity.User;
import com.hh.layuidemo.service.impl.UserService;
import com.hh.layuidemo.service.impl.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public List<User> getUserInfo(String phone){
        List<User> userInfo = userService.getUserInfo("15760467978");
        System.out.println(userInfo);
        return userInfo;
    }
    @RequestMapping("/login")
    @ResponseBody
    public DataInfo verLogin(HttpServletRequest request){
        DataInfo dataInfo=new DataInfo();
        Map<String,Object> retMap=new HashMap<>();
        String phone =request.getParameter("phone");
        String password =request.getParameter("password");
        int userCount = userService.isUser(phone);
        List<User> userInfoList = userService.getUserInfo(phone);
        User user=userInfoList.get(0);
        String pwd=user.getPassword();
        if(userCount==0){
            dataInfo.setData(null);
            dataInfo.setCode(-1);
            dataInfo.setMsg("你还没有注册，请先注册!");
            return dataInfo;
        }
        else {
            if(!password.equals(pwd)){
                dataInfo.setData(null);
                dataInfo.setCode(0);
                dataInfo.setMsg("密码错误");
                return dataInfo;
            }
        }
        dataInfo.setData(userInfoList);
        dataInfo.setCode(1);
        dataInfo.setMsg("登录成功");
        return dataInfo;
    }
}
