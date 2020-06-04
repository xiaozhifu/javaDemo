package com.example.demo.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularController {

    public static void main(String[] args) {
        getTargetString();
    }

    /**
     * 正则获取指定字符串
     */
    public static void getTargetString(){
        String text = "高级房，配备 1 张双人床和 1 张单人沙发床. 选择高级房。面积 24 平方米（258 平方英尺），设计一流，非常舒适：配备 Novotel Live N Dream 双人床、沙发床、空调、光纤无线网络、迷你酒吧、48 英寸大屏幕电视、茶和咖啡器具、瑞雨淋浴，最多可容纳 2 位成人和 1 位儿童";
        Pattern pattern = Pattern.compile("(面积 )(\\d+)( 平方米)");
        Matcher matcher = pattern.matcher("");
        if(matcher.find()){
            String area = matcher.group(2);
            System.out.println(area);
        }
    }

}
