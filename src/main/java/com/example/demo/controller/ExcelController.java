package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.PageData;
import com.example.demo.utils.ExcelExportUtils;
import com.example.demo.utils.ExcelImportUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("excel")
@Slf4j
public class ExcelController {

    /**
     * 导出报表
     *
     * @return
     */
    @GetMapping(value = "/export")
    public void export(HttpServletRequest request, HttpServletResponse response) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //获取数据
        List<PageData> list = new ArrayList<>();
        list.add(new PageData().setPhone("phone1").setUsername("user1").setCreateTime(LocalDateTime.now().plusDays(1L)).setId(1L).setPassword("pwd1"));
        list.add(new PageData().setPhone("phone2").setUsername("user2").setCreateTime(LocalDateTime.now().plusDays(2L)).setId(2L).setPassword("pwd2"));

        //excel标题
        String[] title = {"用户ID", "用户名称", "用户密码", "用户手机", "创建时间"};

        //excel文件名
        String fileName = "用户信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "用户信息表";

        String[][] content = new String[list.size()][5];

        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            PageData obj = list.get(i);
            content[i][0] = obj.getId().toString();
            content[i][1] = obj.getUsername();
            content[i][2] = obj.getPassword();
            content[i][3] = obj.getPhone();
            content[i][4] = dateTimeFormatter.format(obj.getCreateTime());
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelExportUtils.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            log.error("导出 excel 响应流异常:{}", e.getMessage(), e);
        }
    }

    /**
     * 设置响应头
     */
    public void setResponseHeader(HttpServletResponse response, String fileName) throws Exception{
        fileName = new String(fileName.getBytes(), "ISO8859-1");
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
    }

    @PostMapping(value = "/import")
    public String importExcel(@RequestParam MultipartFile mFile){
        try {
            String fileName = mFile.getOriginalFilename();
            // 获取上传文件的输入流
            InputStream inputStream = mFile.getInputStream();
            // titleMapping
            Map<String, String> titleMapping = new HashMap<>();
            titleMapping.put("用户ID", "id");
            titleMapping.put("用户名称", "username");
            titleMapping.put("用户密码", "password");
            titleMapping.put("用户手机", "phone");
            titleMapping.put("创建时间", "createTime");
            // 调用工具类中方法，读取excel文件中数据
            List<PageData> sourceList = ExcelImportUtils.readExcel(fileName, inputStream, titleMapping, PageData.class);
            return sourceList.toString();
        } catch (Exception e) {
            return JSON.toJSONString(e);
        }
    }

}
