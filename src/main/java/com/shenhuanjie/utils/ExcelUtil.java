/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.shenhuanjie.utils;

import com.shenhuanjie.entity.WorkBookEntity;
import com.shenhuanjie.entity.WorkSheetEntity;
import com.shenhuanjie.entity.WorkTableEntity;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    private static Logger log = Logger.getLogger(ExcelUtil.class.getClass());

    public static final String FILE_DIR = "c:" + File.separatorChar + "temp" + File.separatorChar;
    public static final String FILE_SUFFIX = ".xlsx";

    /**
     * 写入Excel文件
     * 生成Zip文件
     *
     * @param fileName
     * @param workbookList
     * @throws IOException
     * @throws WriteException
     */
    public static void writeFactory(String fileName, List<WorkBookEntity> workbookList) throws IOException, WriteException {
        long startTime = System.currentTimeMillis();
        String directory = FILE_DIR + FileUtil.createTimeSamp() + File.separatorChar + fileName + File.separatorChar;

        for (WorkBookEntity workbook : workbookList) {
            writeFactory(directory, workbook);
        }

        // ZipUtil.zip(directory + "\\file.zip", directory);
        FileUtil.createZipFile(directory + fileName + ".zip", directory);
        log.info(">do zipFile:" + directory);

        long endTime = System.currentTimeMillis();
        float excTime = (float) (endTime - startTime) / 1000;
        log.info(">end time:" + excTime + "s");
    }

    ;

    /**
     * 写入Excel文件
     *
     * @param workbookEntity
     * @throws IOException
     * @throws WriteException
     */
    private static void writeFactory(String directory, WorkBookEntity workbookEntity) throws IOException, WriteException {
        String fileName = workbookEntity.getFileName();
        String suffix = FILE_SUFFIX;
        List<WorkSheetEntity> sheetEntityList = workbookEntity.getSheetEntityList();

        File file = FileUtil.assertFile(directory, fileName + suffix);
        WritableWorkbook workbook = Workbook.createWorkbook(file);

        int currentSheet = 0;
        for (WorkSheetEntity sheetEntity : sheetEntityList) {
            int row = 0;
            int column = 0;
            String sheetName = sheetEntity.getSheetName();
            WritableSheet sheet = workbook.createSheet(sheetName, currentSheet);
            List<WorkTableEntity> tableEntityList = sheetEntity.getTableEntityList();
            for (WorkTableEntity tableEntity : tableEntityList) {
                String sheetTitle = tableEntity.getSheetTitle();
                String sheetSubTitle = tableEntity.getSheetSubTitle();
                List<String> columnNameList = tableEntity.getColumnNames();
                List<List<Object>> columnData = tableEntity.getColumnData();

                if (row != 0) {
                    row += columnData.size();
                }
                sheet = writeTitle(sheet, column, row, columnNameList.size() - 1, sheetTitle);
                row++;
                sheet = writeSubTitle(sheet, column, row, columnNameList.size() - 1, sheetSubTitle);
                row++;
                sheet = writeHead(sheet, column, row, columnNameList);
                row++;
                sheet = writeCell(sheet, column, row, columnData);
                row++;
            }
            currentSheet++;
        }
        workbook.write();
        workbook.close();
    }


    /**
     * 创建标题
     *
     * @param sheet
     * @param column
     * @param row
     * @param len
     * @param title
     * @return
     * @throws WriteException
     */
    private static WritableSheet writeTitle(WritableSheet sheet, int column, int row, int len, String title) throws WriteException {
        sheet.mergeCells(column, row, len, row);// 单元格合并方法;
        sheet.addCell(new Label(column, row, title, cellStyle().get("title")));
        return sheet;
    }

    private static WritableSheet writeSubTitle(WritableSheet sheet, int column, int row, int len, String subTitle) throws WriteException {
        sheet.mergeCells(column, row, len, row);// 单元格合并方法;
        sheet.addCell(new Label(column, row, subTitle, cellStyle().get("subtitle")));
        return sheet;
    }

    /**
     * 创建表头
     *
     * @param sheet
     * @param column
     * @param row
     * @param columnHead
     * @return
     * @throws WriteException
     */
    private static WritableSheet writeHead(WritableSheet sheet, int column, int row, List<String> columnHead) throws WriteException {
        for (String head : columnHead) {
            sheet.addCell(new Label(column, row, head, cellStyle().get("head")));
            column++;
        }
        return sheet;
    }

    /**
     * 创建单元格
     *
     * @param sheet
     * @param column
     * @param row
     * @param columnData
     * @return
     * @throws WriteException
     */
    private static WritableSheet writeCell(WritableSheet sheet, int column, int row, List<List<Object>> columnData) throws WriteException {
        int _column = column;
        for (List<Object> columnItem : columnData) {
            for (Object item : columnItem) {
                sheet = addCell(column, row, sheet, item);
                column++;
            }
            column = _column;
            row++;

        }
        return sheet;
    }


    /**
     * 增加单元格
     *
     * @param column     列
     * @param row        行
     * @param sheet
     * @param dataObject
     * @return
     * @throws WriteException
     */
    private static WritableSheet addCell(int column, int row, WritableSheet sheet, Object dataObject)
            throws WriteException {
        if (dataObject != null) {
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            if (dataObject instanceof Integer) {
                sheet.addCell(new Label(column, row, dataObject.toString(), cellStyle().get("content")));
            } else if (dataObject instanceof Double) {
                sheet.addCell(new Label(column, row, decimalFormat.format(Double.parseDouble(dataObject.toString())),
                        cellStyle().get("content")));
            } else if (dataObject instanceof Float) {
                sheet.addCell(new Label(column, row, decimalFormat.format(Float.parseFloat(dataObject.toString())),
                        cellStyle().get("content")));
            } else if (dataObject instanceof Long && dataObject.toString().length() == 13) {
                sheet.addCell(new Label(column, row, decimalFormat.format(Long.parseLong(dataObject.toString())),
                        cellStyle().get("content")));
            } else if (dataObject instanceof Date) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sheet.addCell(new Label(column, row, simpleDateFormat.format(dataObject), cellStyle().get("content")));
            } else {
                sheet.addCell(new Label(column, row, dataObject.toString(), cellStyle().get("content")));
            }
        } else {
            sheet.addCell(new Label(column, row, ""));
        }

        return sheet;
    }

    /**
     * 样式管理器
     *
     * @return
     * @throws WriteException
     */
    private static Map<String, WritableCellFormat> cellStyle() throws WriteException {
        Map<String, WritableCellFormat> map = new HashMap<String, WritableCellFormat>();
        map.put("title", cellTitleFormat());
        map.put("subtitle", cellSubTitleFormat());
        map.put("head", cellHeadFormat());
        map.put("content", cellContentFormat());
        return map;
    }

    /**
     * 创建标题样式
     *
     * @return
     * @throws WriteException
     */
    private static WritableCellFormat cellTitleFormat() throws WriteException {
        WritableFont wf = new WritableFont(WritableFont.createFont("微软雅黑"), 14, WritableFont.BOLD, false,
                UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
        WritableCellFormat wcf = new WritableCellFormat();
        wcf.setFont(wf);
        wcf.setAlignment(Alignment.CENTRE);
        wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
        wcf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        // wcf.setBackground(Colour.GRAY_25);
        // wcf.setWrap(true);
        return wcf;
    }

    /**
     * 创建副标题样式
     *
     * @return
     * @throws WriteException
     */
    private static WritableCellFormat cellSubTitleFormat() throws WriteException {
        WritableFont wf = new WritableFont(WritableFont.createFont("微软雅黑"), 12, WritableFont.BOLD, false,
                UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
        WritableCellFormat wcf = new WritableCellFormat();
        wcf.setFont(wf);
        wcf.setAlignment(Alignment.CENTRE);
        wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
        wcf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        // wcf.setBackground(Colour.GRAY_25);
        // wcf.setWrap(true);
        return wcf;
    }

    /**
     * 创建表头样式
     *
     * @return
     * @throws WriteException
     */
    private static WritableCellFormat cellHeadFormat() throws WriteException {
        WritableFont wf = new WritableFont(WritableFont.createFont("微软雅黑"), 12, WritableFont.BOLD, false,
                UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
        WritableCellFormat wcf = new WritableCellFormat();
        wcf.setFont(wf);
        wcf.setAlignment(Alignment.CENTRE);
        wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
        wcf.setBackground(Colour.GRAY_25);
        wcf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        // wcf.setWrap(true);
        return wcf;
    }

    /**
     * 创建单元格样式
     *
     * @return
     * @throws WriteException
     */
    private static WritableCellFormat cellContentFormat() throws WriteException {
        WritableFont wf = new WritableFont(WritableFont.createFont("微软雅黑"), 12, WritableFont.NO_BOLD, false,
                UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
        WritableCellFormat wcf = new WritableCellFormat();
        wcf.setFont(wf);
        wcf.setAlignment(Alignment.CENTRE);
        wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
        wcf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        // wcf.setBackground(Colour.GRAY_25);
        // wcf.setWrap(true);
        return wcf;
    }

}
