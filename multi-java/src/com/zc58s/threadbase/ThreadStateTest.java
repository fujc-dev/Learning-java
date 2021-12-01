package com.zc58s.threadbase;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/12/1 14:15
 */

public class ThreadStateTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        System.out.println("线程状态：" + thread.getState());
        thread.start();
        System.out.println("线程状态：" + thread.getState());
        Thread.sleep(50);
        System.out.println("线程状态：" + thread.getState());
    }
}
