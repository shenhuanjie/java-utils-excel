/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.shenhuanjie.controller;


import com.shenhuanjie.service.IExcelWriteFactory;
import com.shenhuanjie.service.impl.ExcelWriteType1;
import com.shenhuanjie.service.impl.ExcelWriteType2;

public class ExcelWriteFactory {
    public static final int TYPE_ABFK = 1;//按班分科统计
    public static final int TYPE_ABFSD = 2;//按班分数段统计
    public static final int TYPE_ATKFK = 3;//按题块分科统计
    public static final int TYPE_AXFK = 4;//按校分科统计
    public static final int TYPE_AXZF = 5;//按校总分统计
    public static final int TYPE_ZFCJ = 6;//总分成绩汇总表

    public static IExcelWriteFactory doWrite(int type) {
        switch (type) {
            case TYPE_ABFK:
                return new ExcelWriteType1();
            case TYPE_ABFSD:
                return new ExcelWriteType2();
            case TYPE_ATKFK:
                return new ExcelWriteType1();
            case TYPE_AXFK:
                return new ExcelWriteType1();
            case TYPE_AXZF:
                return new ExcelWriteType1();
            case TYPE_ZFCJ:
                return new ExcelWriteType1();
            default:
                return new ExcelWriteType1();
        }
    }
}
