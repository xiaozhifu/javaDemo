package com.example.demo.thread;

import lombok.SneakyThrows;

public class MyThread extends Thread{

    private String threadName;

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public MyThread(String threadName){
        this.threadName = threadName;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(threadName + "_" + i);
            Thread.sleep(2);
        }
    }

}
