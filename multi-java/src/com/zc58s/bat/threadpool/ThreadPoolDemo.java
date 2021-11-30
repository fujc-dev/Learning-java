package com.zc58s.bat.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/11/30 9:58
 */

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 线程复用，全是临时工，没有正式工，来多少个任务都吃得下
        ExecutorService executorService1 = Executors.newCachedThreadPool();                         //快
        //newFixedThreadPool 没有临时工，全是正式工
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);        //慢
        //有一个正式工，没有临时工
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();                     //很慢
        for (int i = 1; i <= 100; i++) {
            executorService1.execute(new MyTask(i));
        }

        /*
         * ThreadPoolExecutor
         * 使用给定的初始参数和默认线程工厂以及被拒绝的执行处理程序创建一个新的ThreadPoolExecutor 。
         * 使用Executors工厂方法之一而不是这个通用构造函数可能更方便。
         * 参数：
         * corePoolSize – 要保留在池中的线程数，即使它们处于空闲状态，除非设置了allowCoreThreadTimeOut
         * maximumPoolSize – 池中允许的最大线程数
         * keepAliveTime – 当线程数大于核心数时，这是多余空闲线程在终止前等待新任务的最长时间。
         * unit – keepAliveTime参数的时间单位
         * workQueue – 用于在执行任务之前保存任务的队列。 这个队列将只保存execute方法提交的Runnable任务。
         * 抛出：
         * IllegalArgumentException – 如果以下情况之一成立：
         * corePoolSize < 0
         * keepAliveTime < 0
         * maximumPoolSize <= 0
         * maximumPoolSize < corePoolSize
         * NullPointerException – 如果workQueue为空
         */
    }
}
