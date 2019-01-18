/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.shenhuanjie.entity;

import java.io.File;
import java.util.List;

/**
 * Excel 工作簿实体
 */
public class WorkBookEntity {

    /**
     * 文件名
     */
    String fileName;


    /**
     * 工作表列表
     */
    List<WorkSheetEntity> sheetEntityList;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<WorkSheetEntity> getSheetEntityList() {
        return sheetEntityList;
    }

    public void setSheetEntityList(List<WorkSheetEntity> sheetEntityList) {
        this.sheetEntityList = sheetEntityList;
    }

    public WorkBookEntity(String fileName,List<WorkSheetEntity> sheetEntityList) {
        this.fileName = fileName;
        this.sheetEntityList = sheetEntityList;
    }

}
