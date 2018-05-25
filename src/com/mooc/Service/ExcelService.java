package com.mooc.Service;

import com.mooc.Entity.Course;
import org.apache.commons.fileupload.FileItem;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelService {
    /**
     * 解析EXCEL 并获取EXCEL导入结果
     * @param fileItem
     * @return
     */
    public List<Course> imp(FileItem fileItem){
        List<Course> result = new ArrayList<Course>();
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(fileItem.getInputStream());
            Sheet sheet =workbook.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for(int i=1; i<=rowNum; i++){
                Row row = sheet.getRow(i);
                Course course = new Course();
                //课程ID
                course.setCourseId(row.getCell(0).getStringCellValue());
                //课程名
                course.setCourseName(row.getCell(1).getStringCellValue());
                //方向
                course.setCourseType(row.getCell(2).getStringCellValue());
                //描述
                course.setDescription(row.getCell(3).getStringCellValue());
                //时长
                course.setCourseTime(" " + row.getCell(4).getNumericCellValue());
                //操作人
                course.setOperator(row.getCell(5).getStringCellValue());
                result.add(course);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }finally {
            if (workbook!=null){
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
