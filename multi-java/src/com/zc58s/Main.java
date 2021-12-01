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
    // 结论：说白了，这几个线程的状态用一个固定值表示出来，判断线程的状态

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
        //==============================================================================
        //与运算符用符号“&”表示，其使用规律如下：
        //两个操作数中位都为1，结果才为1，否则结果为0，例如下面的程序段。
        System.out.println(1 & 2);
        System.out.println("a 与 b 与的结果是：" + (1 & 2));
        //==============================================================================
        //或运算符用符号“|”表示，其运算规律如下：
        //两个位只要有一个为1，那么结果就是1，否则就为0，下面看一个简单的例子。
        int a=129;
        int b=128;
        System.out.println("a 和b 或的结果是："+(a|b));
        //下面分析这个程序段：
        //a 的值是129，转换成二进制就是10000001，
        // 而b 的值是128，转换成二进制就是10000000，根据或运算符的运算规律，
        // 只有两个位有一个是1，结果才是1，可以知道结果就是10000001，即129。

        //==============================================================================
        //异或运算符是用符号“^”表示的，其运算规律是：两个操作数的位中，相同则结果为0，不同则结果为1。下面看一个简单的例子。
         a = 15;
         b = 2;
        System.out.println("a 与 b 异或的结果是：" + (a ^ b));
        // 分析上面的程序段：a 的值是15，转换成二进制为00001111，
        // 而b 的值是2，转换成二进制为00000010，根据异或的运算规律，可以得出其结果为1101 即13。
        //
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
