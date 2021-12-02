package com.zc58s.sync;

/**
 * @author fjc.dane@gmail.com
 * @createtime : 2021/12/02
 */
public class SyncDemo2 {

    private static volatile int counter = 0;
    private static Object lock = new Object();

    public static void increment() {
        synchronized (lock) {
            counter++;
        }

    }

    public static void decrement() {
        synchronized (lock) {
            counter--;
        }
    }

    /**
     * synchronized 同步阻塞锁
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                increment();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                decrement();
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //思考： counter=？
        System.out.println("counter=" + counter);


    }
}
