/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.shenhuanjie.entity;

import java.util.List;

public class WorkTableEntity {

    /**
     * 标题
     */
    String sheetTitle;
    /**
     * 副标题
     */
    String sheetSubTitle;
    /**
     * 表头
     */
    List<String>columnNames;
    /**
     * 表记录
     */
    List<List<Object>>columnData;

    /**
     * 构造函数

     * @param sheetTitle
     * @param sheetSubTitle
     * @param columnNames
     * @param columnData
     */
    public WorkTableEntity(String sheetTitle, String sheetSubTitle, List<String> columnNames, List<List<Object>> columnData) {
        this.sheetTitle = sheetTitle;
        this.sheetSubTitle = sheetSubTitle;
        this.columnNames = columnNames;
        this.columnData = columnData;
    }

    public String getSheetTitle() {
        return sheetTitle;
    }

    public void setSheetTitle(String sheetTitle) {
        this.sheetTitle = sheetTitle;
    }

    public String getSheetSubTitle() {
        return sheetSubTitle;
    }

    public void setSheetSubTitle(String sheetSubTitle) {
        this.sheetSubTitle = sheetSubTitle;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public List<List<Object>> getColumnData() {
        return columnData;
    }

    public void setColumnData(List<List<Object>> columnData) {
        this.columnData = columnData;
    }
}
