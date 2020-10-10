package com.example.demo.controller;

import org.springframework.util.StringUtils;

public class TestController {

    public static void main(String[] args) {
        String data = "getFromCache";
        if(StringUtils.isEmpty(data)){
            //设置 redis 分布式锁
            boolean hasLock = true;
            if(hasLock){
                //读取数据库
                data = "getFromDB";
                //写入缓存

            }else{
                data = "";
            }
        }
        System.out.println("结果是：" + data);
    }



}
