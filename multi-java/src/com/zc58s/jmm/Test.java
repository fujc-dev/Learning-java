package com.zc58s.jmm;

import com.zc58s.lock.CASLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/12/1 16:11
 */

public class Test {
    private volatile static int sum = 0;
    private static Object lock = new Object();
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static final CASLock casLock = new CASLock();

    /**
     * synchronized (lock)
     * <p>
     * try {
     * reentrantLock.lock();
     * for (int j = 0; j < 10000; j++) {
     * sum++;
     * }
     * } finally {
     * reentrantLock.unlock();
     * }
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (; ; ) {
                    //这是一个自旋锁
                    if (casLock.getState() == 0 && casLock.cas()) {
                        try {
                            for (int j = 0; j < 10000; j++) {
                                sum++;
                            }
                        } finally {
                            casLock.setState(0);
                        }
                        break;
                    }
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
        System.out.println(sum);
    }
}
