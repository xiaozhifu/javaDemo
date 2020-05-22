package com.example.demo.utils;

import com.alibaba.fastjson.JSON;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelImportUtils {

    public static boolean isXls(String fileName) {
        // (?i)忽略大小写
        if (fileName.matches("^.+\\.(?i)(xls)$")) {
            return true;
        } else if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            return false;
        } else {
            throw new RuntimeException("文件格式不对");
        }
    }

    public static <T> List<T> readExcel(String fileName, InputStream inputStream, Map<String, String> titleMapping, Class<T> objClass) throws Exception {
        boolean ret = isXls(fileName);
        Workbook workbook = null;
        // 根据后缀创建不同的对象
        if (ret) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            workbook = new XSSFWorkbook(inputStream);
        }
        Sheet sheet = workbook.getSheetAt(0);
        // 得到标题行
        Row titleRow = sheet.getRow(0);
        // 行数
        int lastRowNum = sheet.getLastRowNum();
        // 列数
        int lastCellNum = titleRow.getLastCellNum();
        // 解析数据
        List<Map<String, Object>> sourceList = new ArrayList<>();
        for (int i = 1; i <= lastRowNum; i++) {
            Map<String, Object> map = new HashMap<>();
            Row row = sheet.getRow(i);
            for (int j = 0; j < lastCellNum; j++) {
                // 得到列名
                String key = titleRow.getCell(j).getStringCellValue();
                Cell cell = row.getCell(j);
                cell.setCellType(CellType.STRING);
                map.put(titleMapping.get(key), cell.getStringCellValue());
            }
            sourceList.add(map);
        }
        workbook.close();
        // 将对象先转为 json 格式字符串，然后再转为 List<T> 对象
        String jsonString = JSON.toJSONString(sourceList);
        // json 字符串转对象
        return JSON.parseArray(jsonString, objClass);
    }

}
