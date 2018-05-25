package com.mooc.Servlet;

import com.mooc.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList=(List<User>) req.getServletContext().getAttribute("userList");
        List<User> newUserList =null;
        String username=req.getParameter("username");
        int i=9999;
        for(User user:userList){
            if(username!=null&&username.equals(user.getUsername())&&!(user.getUsername().equals("imooc"))){
                i=userList.indexOf(user);
            }
        }
        if(i!=9999){
            userList.remove(i);
        }
        req.getServletContext().setAttribute("userList",userList);
        req.getSession().setAttribute("userList",userList);
        req.getRequestDispatcher("/mooc/selectUser.do").forward(req,resp);
    }
}
