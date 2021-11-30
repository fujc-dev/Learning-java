package com.zc58s.bat.threadpool;

import java.util.concurrent.*;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/11/30 9:58
 */

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 线程复用，全是临时工，没有正式工，来多少个任务都吃得下
        ExecutorService executorService1 = Executors.newCachedThreadPool();                         //快
        //newFixedThreadPool 没有临时工，全是正式工，正儿八经的良心公司
        //LinkedBlockingQueue 队列无限大，意思就是说，可以接收无限个任务
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);        //慢
        //有一个正式工，没有临时工，个体户，老板是你，员工是你，财务是你，清洁工也是你，啥都是你
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();                     //很慢

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                20,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10)  //指定列队容量为10，当任务在队列存不进去时，就会报错，就会被拒绝，或者进入拒绝策略
        );
        //当我们自定义线程池的时候，核心数量为10，，我们将队列容量设置为10
        //


        //10 11 12
        //场景分析：阿里有一个促销节，是双11，同一个处理，双11的处理量可能是100，而非双11是10，此时我们的线程该如何定义？
        //corePoolSize 10
        //maximumPoolSize 100
        //为什么我们在阿里的Java开发手册中，看到有一条说的是，不建议使用Executors创建线程
        //会导致 CPU 100% 的问题

        // [executorService1] 最容易出现OOM
        // Executors.newCachedThreadPool();
        //maximumPoolSize = Integer.MAX_VALUE，会导致 CPU 100% 的问题
        //如果不是在互联网公司，对Executors的限制没有那么强烈
        //1、无界队列

        for (int i = 1; i <= 100; i++) {
            threadPoolExecutor.execute(new MyTask(i));
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
