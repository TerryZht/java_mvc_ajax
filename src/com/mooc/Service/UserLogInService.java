package com.mooc.Service;

import com.mooc.Entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserLogInService {
    /**
     * 判断用户是否登录
     * @param request
     * @param response
     * @return
     */
    public static boolean ifLogin(HttpServletRequest request, HttpServletResponse response){
        boolean sucessFlg=false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("checkCode");
        if(code==null){
            return sucessFlg;
        }
        List<User> userList=(List<User>) request.getServletContext().getAttribute("userList");

        for(User user : userList){
            if(username!=null && username.equals(user.getUsername()) && password!=null && password.equals(user.getPassword())){
                sucessFlg=true;
                request.getSession().setAttribute("loginUser",username);
                if(user.getRole().equals("超级管理员")){
                    request.getSession().setAttribute("superFlg",1);
                }else {
                    request.getSession().setAttribute("superFlg",0);
                }
            }
        }
        return sucessFlg;
    }
}
