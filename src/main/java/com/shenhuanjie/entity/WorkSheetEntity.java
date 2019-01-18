/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.shenhuanjie.entity;

import java.util.List;

public class WorkSheetEntity {
    /**
     * 工作表名称
     */
    String sheetName;

    List<WorkTableEntity> tableEntityList;

    public WorkSheetEntity(String sheetName, List<WorkTableEntity> tableEntityList) {
        this.sheetName = sheetName;
        this.tableEntityList = tableEntityList;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<WorkTableEntity> getTableEntityList() {
        return tableEntityList;
    }

    public void setTableEntityList(List<WorkTableEntity> tableEntityList) {
        this.tableEntityList = tableEntityList;
    }
}
