package com.tss.tasks;

public class MyTask implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
