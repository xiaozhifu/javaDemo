package com.example.demo.controller;

import java.net.MalformedURLException;

public class TestController {

    public static void main(String[] args) throws MalformedURLException {

        long serialNumber = 1L;
        String res =  String.format("D%07d", serialNumber);

        System.out.println(res);

    }

}
