package com.tss.test;

import com.tss.tasks.MyTask;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

//        Thread thread1 = new Thread(()-> System.out.println(Thread.currentThread().getName()));

        //here it will decide on its own that how many thread it needs to create
        ExecutorService service = Executors.newCachedThreadPool();

        //now we will decide how many number of threads we want to create
        ExecutorService service1 = Executors.newFixedThreadPool(10);

        for(int i =0; i < 100; i++)
        {
            service1.execute(new MyTask());
        }
    }


}
