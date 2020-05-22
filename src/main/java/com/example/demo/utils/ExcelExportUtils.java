package com.example.demo.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.util.HashMap;
import java.util.Map;

public class ExcelExportUtils {

    /**
     * 导出Excel
     *
     * @param sheetName sheet名称
     * @param title     标题
     * @param values    内容
     * @param wb        HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[][] values, HSSFWorkbook wb) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，申明行对象、列对象
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = null;

        // 表头样式
        HSSFCellStyle style = wb.createCellStyle();
        // 居中
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        // 字体
        HSSFFont font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 12);
        style.setFont(font);
        // 自动换行
        style.setWrapText(true);
        // 存储最大列宽
        Map<Integer, Integer> maxWidth = new HashMap<>();

        //创建表头
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            // 设置表头样式
            cell.setCellStyle(style);
            maxWidth.put(i, cell.getStringCellValue().getBytes().length * 256 + 200);
        }

        //创建内容
        for (int i = 0; i < values.length; i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < values[i].length; j++) {
                //将内容按顺序赋给对应的列对象
                cell = row.createCell(j);
                cell.setCellValue(values[i][j]);
                int length = cell.getStringCellValue().getBytes().length * 256 + 200;
                //这里把宽度最大限制到15000
                if (length > 15000) {
                    length = 15000;
                }
                maxWidth.put(j, Math.max(length, maxWidth.get(j)));
            }
        }

        // 列宽自适应
        for (int i = 0; i < title.length; i++) {
            sheet.setColumnWidth(i, maxWidth.get(i));
        }

        return wb;
    }

}
