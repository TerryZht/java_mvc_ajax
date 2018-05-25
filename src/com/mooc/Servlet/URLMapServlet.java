package com.mooc.Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class URLMapServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.equals(req.getServletPath(),"/server.do")){
            req.getRequestDispatcher("/WEB-INF/views/server.jsp").forward(req,resp);
        }else if(Objects.equals(req.getServletPath(),"/top.do")){
            req.getRequestDispatcher("/WEB-INF/views/top.jsp").forward(req,resp);
        }else if(Objects.equals(req.getServletPath(),"/left.do")){
            req.getRequestDispatcher("/WEB-INF/views/left.jsp").forward(req,resp);
        }else if(Objects.equals(req.getServletPath(),"/mooc/addUser.do")){
            req.getRequestDispatcher("/WEB-INF/views/addUser.jsp").forward(req,resp);
        }else if(Objects.equals(req.getServletPath(),"/mooc/addCourse.do")){
            req.getRequestDispatcher("/WEB-INF/views/addCourse.jsp").forward(req,resp);
        }else if(Objects.equals(req.getServletPath(),"/mooc/courseImport.do")){
            req.getRequestDispatcher("/WEB-INF/views/courseImport.jsp").forward(req,resp);
        }else if(Objects.equals(req.getServletPath(),"/mooc/selectUser.do")){
            req.getRequestDispatcher("/WEB-INF/views/selectUsers.jsp").forward(req,resp);
        }else if(Objects.equals(req.getServletPath(),"/mooc/selectCourse.do")){
            req.getRequestDispatcher("/WEB-INF/views/showCourse.jsp").forward(req,resp);
        }else if(Objects.equals(req.getServletPath(),"/mook_course")){
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
        }
    }
}
