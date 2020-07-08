package com.example.demo.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternController {

    public static void main(String[] args) {

        String fileName = "1546_ba_00_p_3000x2250_20200624.jpg";

        System.out.println("byPattern:" + byPattern(fileName));

        System.out.println("byIndex:" + byIndex(fileName));

    }

    public static Integer byPattern(String fileName){
        int sortId = 999;
        Pattern pattern = Pattern.compile("(_)(\\d+)(_)");
        Matcher matcher = pattern.matcher(fileName);
        if(matcher.find()){
            String sortStr = matcher.group(2);
            sortId = Integer.parseInt(sortStr);
        }
        return sortId;
    }

    public static Integer byIndex(String fileName){
        int sortId = 999;
        int startIndex = 0;
        int endIndex = 0;
        Matcher mat= Pattern.compile("_").matcher(fileName);
        int time = 1;
        while(mat.find()){
            if(time == 2){
                startIndex = mat.start();
            }else if(time == 3){
                endIndex = mat.start();
            }else{ }
            time++;
        }
        if(endIndex > startIndex && startIndex > 0){
            String sortStr = fileName.substring(startIndex+1, endIndex);
            sortId = Integer.parseInt(sortStr);
        }
        System.out.println(startIndex + "----" + endIndex);
        return sortId;
    }

}
