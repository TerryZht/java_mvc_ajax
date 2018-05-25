package com.mooc.Entity;

import org.apache.commons.fileupload.FileItem;

import java.util.HashMap;
import java.util.Map;

public class ParmParse {
    private Map<String,String> parmMap;
    private Map<String,FileItem> fileMap;

    public ParmParse() {
        parmMap = new HashMap<String,String>();
        fileMap = new HashMap<String,FileItem>();
    }

    public Map<String, String> getParmMap() {
        return parmMap;
    }

    public void setParmMap(Map<String, String> parmMap) {
        this.parmMap = parmMap;
    }

    public Map<String, FileItem> getFileMap() {
        return fileMap;
    }

    public void setFileMap(Map<String, FileItem> fileMap) {
        this.fileMap = fileMap;
    }
}
