package com.mooc.Servlet;

import com.mooc.Entity.Course;
import com.mooc.Utils.CourseImportParse;
import com.mooc.Service.ExcelService;
import com.mooc.Entity.ParmParse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CourseImportServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(ServletFileUpload.isMultipartContent(req)){
            ParmParse parmParse = CourseImportParse.parseParm(req);
            FileItem excel = parmParse.getFileMap().get("file1");
            ExcelService excelService = new ExcelService();
            List<Course> courses = excelService.imp(excel);
            List<Course> coursesBefore = (List<Course>) req.getServletContext().getAttribute("courses");
            courses.addAll(coursesBefore);
            req.getServletContext().setAttribute("courses",courses);
            req.getSession().setAttribute("courses",courses);
            req.getRequestDispatcher("/WEB-INF/views/showCourse.jsp").forward(req,resp);
        }else {
            System.out.println("导入非EXCEL");
        }
    }
}
