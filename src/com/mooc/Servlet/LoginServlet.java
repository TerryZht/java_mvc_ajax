package com.mooc.Servlet;

import com.mooc.Entity.User;
import com.mooc.Service.UserLogInService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (UserLogInService.ifLogin(req,resp)){
            req.getRequestDispatcher("/WEB-INF/views/server.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/mook_course").forward(req,resp);
        }
    }
}
