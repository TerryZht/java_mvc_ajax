package com.mooc.Servlet;


import com.mooc.Entity.Course;
import com.mooc.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InitServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        User supper = new User("imooc","imooc","超级管理员");
        List<User> userList = new ArrayList<User>();
        userList.add(supper);
        this.getServletContext().setAttribute("userList",userList);
        List<Course> courses = new ArrayList<>();
        this.getServletContext().setAttribute("courses",courses);
    }
}
