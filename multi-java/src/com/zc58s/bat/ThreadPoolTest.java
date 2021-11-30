package com.zc58s.bat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/11/30 9:28
 */

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor(); //java 自带的线程池
        for (int i = 0; i < 100000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        //这里只创建了一个工作线程
        System.out.println("时间：" + (System.currentTimeMillis() - start));
        System.out.println("大小：" + list.size());
    }
}
