/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.shenhuanjie.utils;

import com.shenhuanjie.constant.ExcelType;
import com.shenhuanjie.controller.ExcelWriteFactory;
import com.shenhuanjie.entity.WorkBookEntity;
import com.shenhuanjie.service.IExcelWriteFactory;
import junit.framework.TestCase;
import jxl.write.WriteException;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtilTest extends TestCase {
    private static Logger log = Logger.getLogger(ExcelUtilTest.class.getClass());


    /**
     * @throws IOException
     * @throws WriteException
     */
    @Test
    public final void testWrite() throws IOException, WriteException {
        List<WorkBookEntity> workbookList = new ArrayList<WorkBookEntity>();

        String fileName = "2018年秋小学三年级期末考试";
        IExcelWriteFactory excelBook1 = ExcelWriteFactory.doWrite(ExcelType.TYPE_ABFK.getVal());
        IExcelWriteFactory excelBook2 = ExcelWriteFactory.doWrite(ExcelType.TYPE_ABFSD.getVal());
        IExcelWriteFactory excelBook3 = ExcelWriteFactory.doWrite(ExcelType.TYPE_ATKFK.getVal());
        IExcelWriteFactory excelBook4 = ExcelWriteFactory.doWrite(ExcelType.TYPE_AXFK.getVal());
        IExcelWriteFactory excelBook5 = ExcelWriteFactory.doWrite(ExcelType.TYPE_AXZF.getVal());
        IExcelWriteFactory excelBook6 = ExcelWriteFactory.doWrite(ExcelType.TYPE_ZFCJ.getVal());

        workbookList.add(excelBook1.write(fileName));
        workbookList.add(excelBook2.write(fileName));
        workbookList.add(excelBook3.write(fileName));
        workbookList.add(excelBook4.write(fileName));
        workbookList.add(excelBook5.write(fileName));
        workbookList.add(excelBook6.write(fileName));

        ExcelUtil.writeFactory(fileName, workbookList);
    }
}