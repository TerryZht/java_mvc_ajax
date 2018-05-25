package com.mooc.Servlet;

import com.mooc.Service.PagePartionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//分页AJAX
public class PagePartionServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PagePartionService.getCourse(req,resp);

    }
}
