package com.example.demo.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternController {

    public static void main(String[] args) {

        getTargetString();

    }

    /**
     * 正则获取指定字符串
     */
    public static void getTargetString(){
        String text = "Superior room with double bed, Jean-Philippe Nuel design. Contemporary design, from 25 sqm, Sofitel MyBed TM, shower, Hermes courtesy set, Illy coffee machine and Dammann tea machine, minibar, BOSE sound system, 49\" TV, free WI-FI.";
        Pattern pattern = Pattern.compile("(from )(\\d+)( sqm)");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            String area = matcher.group(2);
            System.out.println(area);
        }
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
