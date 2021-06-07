package com.hh.layuidemo.interceptor;

import com.hh.layuidemo.entity.User;
import com.hh.layuidemo.service.impl.UserService;
import com.hh.layuidemo.util.CookieUtil;
import com.hh.layuidemo.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class LoginTicketInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String pp=CookieUtil.getValue(request,"phone");
        String phone =request.getParameter("phone");
        User userInfo = userService.getUserInfo(phone);
        hostHolder.setUser(userInfo);*/
        String phone =request.getParameter("phone");
        User userInfo = userService.getUserInfo(phone);
        hostHolder.setUser(userInfo);
        return true;
    }
}
