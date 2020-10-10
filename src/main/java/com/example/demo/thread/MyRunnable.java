package com.example.demo.thread;

import lombok.SneakyThrows;

public class MyRunnable implements Runnable{

    private String threadName;

    public MyRunnable(String threadName){
        this.threadName = threadName;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
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
