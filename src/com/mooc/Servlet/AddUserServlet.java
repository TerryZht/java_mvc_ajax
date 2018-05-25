package com.mooc.Servlet;

import com.mooc.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=new User(username,password,"普通管理员");
        List<User> userList=(List<User>) req.getServletContext().getAttribute("userList");
        userList.add(user);
        req.getSession().setAttribute("userList",userList);
        req.getServletContext().setAttribute("userList",userList);
        req.getRequestDispatcher("/mooc/selectUser.do").forward(req,resp);
    }
}
