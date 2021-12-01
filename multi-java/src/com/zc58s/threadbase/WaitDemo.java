package com.zc58s.threadbase;

/**
 * 线程等待唤醒
 *
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/12/1 15:36
 */

public class WaitDemo {
    private static Object lock = new Object();
    private static boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (flag) {
                        try {
                            System.out.println("wait start .....");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("wait end ......");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (flag) {
                    synchronized (lock) {
                        if (flag) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        lock.notifyAll();
                        System.out.println("notify....");
                        flag = false;
                    }
                }
            }
        }).start();
    }
}
