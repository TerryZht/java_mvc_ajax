package com.mooc.Service;

import com.mooc.Entity.Course;
import com.mooc.Utils.ArrayToJson;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 分页逻辑，可继续优化 代码太乱
 */
public class PagePartionService {
    public static void getCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cType = req.getParameter("cType");
        int currPage = Integer.parseInt(req.getParameter("curr"));
        int currP=0;
        List<Course> selectCourses=null;
        int allCnt=1;
        List<Course> courses = (List<Course>)req.getSession().getAttribute("courses");
        try{
            allCnt= courses.size();
        }catch (java.lang.NullPointerException e){
            allCnt=0;
        }
        int itemCnt=0;
        try{
            itemCnt = Integer.parseInt(req.getParameter("itemCnt"));
        }catch (java.lang.NumberFormatException e){
            itemCnt = allCnt;
        }
        int start=0;
        int end=0;
        int cnt=0;
        if(cType.equals("first")){
            System.out.println("首页");
            JSONArray jsonArray = new JSONArray();
            if(itemCnt<courses.size()) {
                selectCourses = courses.subList(0, itemCnt);
                start=1;
                end=itemCnt;
                cnt=itemCnt;
            }else
            {
                selectCourses = courses.subList(0, courses.size());
                start=1;
                end=courses.size();
                cnt=courses.size();
            }
            for(Course course:selectCourses) {
                if(course!=null){
                    ArrayToJson.courseToJson(course,jsonArray);
                }
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("start",start);
            jsonObject.put("end",end);
            jsonObject.put("cnt",cnt);
            jsonObject.put("currPage","1");
            jsonArray.put(jsonObject);
            req.getSession().setAttribute("selectCourses",selectCourses);
            resp.getOutputStream().write(jsonArray.toString().getBytes("utf-8"));
        }else if(cType.equals("lst")) {
            System.out.println("尾页");
            JSONArray jsonArray = new JSONArray();
            selectCourses=courses.subList(((allCnt/itemCnt)*itemCnt),courses.size());
            for(Course course:selectCourses) {
                if(course!=null){
                    ArrayToJson.courseToJson(course,jsonArray);
                }
            }
            start=(allCnt/itemCnt)*itemCnt+1;
            end=courses.size();
            cnt=(courses.size())-((allCnt/itemCnt)*itemCnt);
            currP=(allCnt/itemCnt)+1;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("start",start);
            jsonObject.put("end",end);
            jsonObject.put("cnt",cnt);
            jsonObject.put("currPage",currP);
            jsonArray.put(jsonObject);
            req.getSession().setAttribute("selectCourses",selectCourses);
            resp.getOutputStream().write(jsonArray.toString().getBytes("utf-8"));
        }else if(cType.equals("pre")){
            System.out.println("上一页");
            JSONArray jsonArray = new JSONArray();
            currP=currPage-1;
            if(currP<0) {
                selectCourses = courses.subList(0, itemCnt * currP);
            }else {
                selectCourses = courses.subList((currP - 1) * itemCnt , itemCnt * currP );
            }
            for(Course course:selectCourses) {
                if(course!=null){
                    ArrayToJson.courseToJson(course,jsonArray);
                }
            }
            start=(currP-1)*itemCnt+1;
            end=itemCnt*currP;
            cnt=end-start+1;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("start",start);
            jsonObject.put("end",end);
            jsonObject.put("cnt",cnt);
            jsonObject.put("currPage",currP);
            jsonArray.put(jsonObject);
            req.getSession().setAttribute("selectCourses",selectCourses);
            resp.getOutputStream().write(jsonArray.toString().getBytes("utf-8"));

        }else if(cType.equals("nxt")){
            System.out.println("下一页");
            JSONArray jsonArray = new JSONArray();
            currP=currPage+1;
            try {
                selectCourses = courses.subList((currP - 1) * itemCnt, itemCnt * currP);
            }catch (java.lang.IndexOutOfBoundsException e){
                selectCourses = courses.subList((currP - 1) * itemCnt, courses.size());
            }
            for(Course course:selectCourses) {
                if(course!=null){
                    ArrayToJson.courseToJson(course,jsonArray);
                }
            }
            start=(currP-1)*itemCnt +1;
            if(currPage==((allCnt/itemCnt))) {
                end = courses.size();
            }else{
                end=itemCnt * currP;
            }
            cnt=end-start+1;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("start",start);
            jsonObject.put("end",end);
            jsonObject.put("cnt",cnt);
            jsonObject.put("currPage",currP);
            jsonArray.put(jsonObject);
            req.getSession().setAttribute("selectCourses",selectCourses);
            resp.getOutputStream().write(jsonArray.toString().getBytes("utf-8"));
        }

    }

}
