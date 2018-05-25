package com.mooc.Service;

import com.mooc.Entity.Course;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class ExportCourseService {
    public static void exportCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Course> selectCourses = (List<Course>)req.getSession().getAttribute("selectCourses");
        UUID uuid = UUID.randomUUID();
        String filename = uuid.toString()+".xlsx";
        Workbook workbook;
        //07版EXCEL
        workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("My Courses");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("课程ID");
        row.createCell(1).setCellValue("课程名");
        row.createCell(2).setCellValue("方向");
        row.createCell(3).setCellValue("描述");
        row.createCell(4).setCellValue("时长(小时)");
        row.createCell(5).setCellValue("操作人");
        for(int i=0;i<selectCourses.size();i++){
            row = sheet.createRow(i+1);
            Course course = selectCourses.get(i);
            row.createCell(0).setCellValue(course.getCourseId());
            row.createCell(1).setCellValue(course.getCourseName());
            row.createCell(2).setCellValue(course.getCourseType());
            row.createCell(3).setCellValue(course.getDescription());
            row.createCell(4).setCellValue(course.getCourseTime());
            row.createCell(5).setCellValue(course.getOperator());
        }
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        ServletOutputStream outputStream = resp.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        workbook.close();
    }
}
