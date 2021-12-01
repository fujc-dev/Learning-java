package com.zc58s;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 */
public class Main {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    //https://tool.lu/hexconvert/ 进制转换工具验证地址
    // << 左移
    // 1的二进制为00000001 ===> 左移一位二进制就变成 00000010 ===> 十进制就是2
    //System.out.println(1 << 1);
    // >> 右移


    public static void main(String[] args) {
        // 1的二进制为00000001 ===> 左移一位二进制就变成 00000010 ===> 十进制就是2
        System.out.println(1 << 1);
        // 1的二进制为00000001 ===> 右移一位二进制就变成 00000000 ===> 十进制就是0
        // 16的二进制为00010000 ===> 右移一位二进制就变成 00001000  ==> 十进制就是8
        System.out.println(1 >> 1);

        //ThreadPoolExecutor
        //ScheduledThreadPoolExecutor

        //这里会传递一个核心的线程个数，声明正式工5个
        //ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
        //executor.schedule();
        // executor.scheduleWithFixedDelay();
        //scheduleAtFixedRate
        //executor.scheduleAtFixedRate();


    }
}
