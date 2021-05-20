package com.example.demo.controller;

import java.net.MalformedURLException;

public class TestController {

    private ThreadLocal b = new ThreadLocal();

    public static void main(String[] args) throws MalformedURLException {

        Thread a = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("1");
            }

        });

        a.start();

    }

}
