package com.zc58s.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/12/1 16:58
 */

public class AtomicIntegerTest {

    private static final AtomicInteger sum = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    sum.incrementAndGet();
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(3000);
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
        //
        System.out.println(sum.get());
    }
}
