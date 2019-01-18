/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.shenhuanjie.constant;

public enum ExcelType {
    /**
     * 文件后面名
     */
    TYPE_ABFK("TYPE_ABFK", 1),//按班分科统计
    TYPE_ABFSD("TYPE_ABFSD", 2),//按班分数段统计
    TYPE_ATKFK("TYPE_ATKFK", 3),//按题块分科统计
    TYPE_AXFK("TYPE_ATKFK", 4),//按校分科统计
    TYPE_AXZF("TYPE_AXZF", 5),//按校总分统计
    TYPE_ZFCJ("TYPE_ZFCJ", 6);//总分成绩汇总表

    private String name;
    private int val;

    ExcelType(String name, int val) {
        this.name = name;
        this.val = val;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "FileType{" +
                "name='" + name + '\'' +
                ", val=" + val +
                '}';
    }
}
