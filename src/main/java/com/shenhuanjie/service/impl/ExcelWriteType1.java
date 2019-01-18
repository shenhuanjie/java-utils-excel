/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.shenhuanjie.service.impl;

import com.shenhuanjie.entity.WorkBookEntity;
import com.shenhuanjie.entity.WorkSheetEntity;
import com.shenhuanjie.entity.WorkTableEntity;
import com.shenhuanjie.service.IExcelWriteFactory;

import java.util.ArrayList;
import java.util.List;

public class ExcelWriteType1 extends IExcelWriteFactory {
    @Override
    public WorkBookEntity write(String fileName) {

        String subFileName="分校统计报表";

        List<String> columnNameList = new ArrayList<String>();
        columnNameList.add("学校");
        columnNameList.add("姓名");
        columnNameList.add("考号");
        columnNameList.add("成绩");
        columnNameList.add("学校");
        columnNameList.add("姓名");
        columnNameList.add("考号");
        columnNameList.add("成绩");
        columnNameList.add("学校");
        columnNameList.add("姓名");
        columnNameList.add("考号");
        columnNameList.add("成绩");
        columnNameList.add("学校");
        columnNameList.add("姓名");
        columnNameList.add("考号");
        columnNameList.add("成绩");

        List<WorkSheetEntity> sheetList = new ArrayList<WorkSheetEntity>();

        List<WorkTableEntity>tableEntityList=new ArrayList<WorkTableEntity>();
        List<List<Object>> columnData = new ArrayList<List<Object>>();
        for (int i = 0; i < 1000; i++) {
            List<Object> data = new ArrayList<Object>();
            data.add("德诚小学");
            data.add("沈焕杰");
            data.add(20180117);
            data.add(100.00);
            data.add("德诚小学");
            data.add("沈焕杰");
            data.add(20180117);
            data.add(100.00);
            data.add("德诚小学");
            data.add("沈焕杰");
            data.add(20180117);
            data.add(100.00);
            data.add("德诚小学");
            data.add("沈焕杰");
            data.add(20180117);
            data.add(100.00);
            columnData.add(data);
        }
        WorkTableEntity workTableEntity=new WorkTableEntity(fileName,"分科分班统计报表" , columnNameList, columnData);
        tableEntityList.add(workTableEntity);
        // tableEntityList.add(workTableEntity);
        // tableEntityList.add(workTableEntity);
        // tableEntityList.add(workTableEntity);
        // tableEntityList.add(workTableEntity);
        sheetList.add(new WorkSheetEntity("语文", tableEntityList));
        sheetList.add(new WorkSheetEntity("数学", tableEntityList));
        sheetList.add(new WorkSheetEntity("英语", tableEntityList));
        return  new WorkBookEntity(subFileName, sheetList);
    }
}
