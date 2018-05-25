package com.mooc.Servlet;

import com.mooc.Utils.CaptcahCode;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setHeader("pragma","no-cache");
//        response.setHeader("cache-control","no-cache");
//        response.setHeader("expires","0");
        String code = CaptcahCode.getCaptcah(4);
//        request.getSession().setAttribute("ssss",code);
//        System.out.println(code);
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonArray.put(jsonObject);
        response.getOutputStream().write(jsonArray.toString().getBytes("utf-8"));

    }
}
