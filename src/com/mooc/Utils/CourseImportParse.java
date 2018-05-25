package com.mooc.Utils;

import com.mooc.Entity.ParmParse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class CourseImportParse {
    /**
     * 解析表单请求参数，并上传文件
     * @param request
     */
    public static ParmParse parseParm(HttpServletRequest request){
        ParmParse result = new ParmParse();
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        upload.setHeaderEncoding("UTF-8");
        try {
            List<FileItem> fileItemList =  upload.parseRequest(request);
            for(FileItem fileItem :fileItemList){
                if(fileItem.isFormField()){
                    result.getParmMap().put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
                }else{
                    //文件流
                    result.getFileMap().put(fileItem.getFieldName(),fileItem);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
