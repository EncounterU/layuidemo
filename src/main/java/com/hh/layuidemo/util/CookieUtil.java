package com.hh.layuidemo.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

//获取cookie
public class CookieUtil {
    public static String getValue(HttpServletRequest request,String name){
        if(request==null||name==null){
            throw new IllegalArgumentException("参数为空！");//这是一个参数异常
        }
        Cookie[] cookies = request.getCookies();//cookie数组，可以从request中得到
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(name)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
