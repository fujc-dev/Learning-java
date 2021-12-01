package com.zc58s.threadbase;

import java.util.concurrent.locks.LockSupport;

/**
 * 线程等待唤醒
 *
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/12/1 15:36
 */

public class LockSupportTest {


    public static void main(String[] args) {
        Thread parkThread = new Thread(new ParkThread());
        parkThread.start();
        System.out.println("唤醒parkThread");

        Thread parkThread2 = new Thread(new ParkThread());
        parkThread2.start();
        System.out.println("唤醒parkThread2");
        //
        LockSupport.unpark(parkThread);
        LockSupport.unpark(parkThread2);
    }

    public static class ParkThread implements Runnable {

        @Override
        public void run() {
            System.out.println("parkThread 开始执行");
            //等待许可，阻塞线程，等待唤醒
            LockSupport.park();
            System.out.println("parkThread 执行完成");
        }
    }
}
