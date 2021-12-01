package com.zc58s.threadbase;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/12/1 14:39
 */

public class ThreadExecuteTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("通过Runnable方式执行任务");
            }
        };
        //底层操作系统会创建线程，这个start调用一个native方法
        //java Thread --> jvm JavaThread --> os Thread -->
        //-->  native_thread java thread 建立关系
        //-->
        new Thread(runnable).start();
        //分析：
        //没有调用start，仅仅是一个类方法的调用
        new Thread(runnable).run();
        //同上
        runnable.run();

        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("通过Callable方式执行任务");
                Thread.sleep(1000);
                return "返回任务结果";
            }
        });
        new Thread(task).start();
        System.out.println(task.get());

        //
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
