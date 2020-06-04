package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestController {

    public static void main(String[] args) {
        List<String> a = Collections.emptyList();
        a = new ArrayList<>();
        a.add("1");
        String result = a.stream().filter(s -> s.equals("1")).findAny().orElseGet(()->{
            return "haha";
        });
        System.out.println(result);
    }

}
