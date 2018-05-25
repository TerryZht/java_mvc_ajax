package com.mooc.Service;
import com.mooc.DAO.SearchCourse;
import com.mooc.Entity.Course;
import com.mooc.Utils.ArrayToJson;
import org.json.JSONArray;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PageSearchService {
    public static void getCourses(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String searchValue =req.getParameter("searchValue");
        JSONArray jsonArray = new JSONArray();
        List<Course> courses = (List<Course>) req.getSession().getAttribute("courses");
        List<Course> selectCourses = null;
        for(Course course:courses) {
            Course resCourse = SearchCourse.searchCourse(course,searchValue);
            if(resCourse!=null){
                selectCourses.add(course);
                ArrayToJson.courseToJson(course,jsonArray);
            }
        }
        req.getSession().setAttribute("selectCourses",selectCourses);
        resp.getOutputStream().write(jsonArray.toString().getBytes("utf-8"));
    }
}
