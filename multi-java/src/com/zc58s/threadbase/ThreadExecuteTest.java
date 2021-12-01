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
        new Thread(runnable).start();
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
    }
}
