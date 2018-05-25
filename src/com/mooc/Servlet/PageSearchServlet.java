package com.mooc.Servlet;

import com.mooc.Service.PageSearchService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//搜索AJAX
public class PageSearchServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageSearchService.getCourses(req,resp);
    }
}
