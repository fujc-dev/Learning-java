package com.zc58s;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        //ThreadPoolExecutor
        //ScheduledThreadPoolExecutor

        //这里会传递一个核心的线程个数，声明正式工5个
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
        //executor.schedule();
        // executor.scheduleWithFixedDelay();
        //scheduleAtFixedRate
        //executor.scheduleAtFixedRate();
    }
}
