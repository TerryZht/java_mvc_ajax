package com.mooc.Utils;

import com.mooc.Entity.Course;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArrayToJson {
    public static void courseToJson(Course course, JSONArray jsonArray){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("courseId",course.getCourseId());
        jsonObject.put("courseName",course.getCourseName());
        jsonObject.put("courseType",course.getCourseType());
        jsonObject.put("description",course.getDescription());
        jsonObject.put("courseTime",course.getCourseTime());
        jsonObject.put("operator",course.getOperator());
        jsonArray.put(jsonObject);
    }
}
