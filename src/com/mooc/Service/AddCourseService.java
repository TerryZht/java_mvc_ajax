package com.mooc.Service;

import com.mooc.Entity.Course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddCourseService {
    /**
     * 将请求课程信息加入courseList
     * @param req
     * @param resp
     */
    public static void addCourse(HttpServletRequest req, HttpServletResponse resp){
        String courseId = req.getParameter("courseId");
        String courseName = req.getParameter("courseName");
        String courseType =  req.getParameter("courseType");
        String description = req.getParameter("description");
        String courseTime = req.getParameter("courseTime");
        String operator = req.getParameter("operator");
        Course course = new Course(courseId,courseName,courseType,description,courseTime,operator);
        List<Course> courses = (List<Course>) req.getServletContext().getAttribute("courses");
        courses.add(course);
        req.getSession().setAttribute("courses",courses);
        req.getServletContext().setAttribute("courses",courses);
    }
}
