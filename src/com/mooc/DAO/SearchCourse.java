package com.mooc.DAO;

import com.mooc.Entity.Course;

public class SearchCourse {
    public static Course searchCourse(Course course, String searchValue){
        Course result = null;
        if(
        course.getCourseId().contains(searchValue) ||
        course.getCourseName().contains(searchValue) ||
        course.getCourseTime().contains(searchValue) ||
        course.getCourseType().contains(searchValue)||
        course.getDescription().contains(searchValue)||
        course.getOperator().contains(searchValue)){
            result=course;
            return result;
        }
        return  result;
    }
}
