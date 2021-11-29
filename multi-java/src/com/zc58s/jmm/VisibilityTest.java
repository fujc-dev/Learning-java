package com.zc58s.jmm;

import sun.misc.Unsafe;

/**
 * 可见性问题：
 *
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/11/15 11:36
 */
public class VisibilityTest {

    private  boolean flag = true;
    //Integer，会执行 new Integer(value)，而里面的value的被一个final关键字修饰的。
    private int count = 0;


    public void refresh() {
        flag = false;
        System.out.println(Thread.currentThread().getName() + "修改Flag：" + flag);
    }

    public void load() {
        System.out.println(Thread.currentThread().getName() + "开始执行.....");

//        for (int i = 0; i < 10000000; i++) {
//            count++;
//            if (!flag) {
//                break;
//            }
//        }
        // while 的特殊性，这里优先级太高了，导致了，cpu时间片的抢占，一直在计算，没有获取threadB同步的最新的主存数据（flag = false）。
        // 我们替换成for循环的时候，flag的可见性问题，好像就不会出现了？为什么？
        // 因为while的时候，优先级太高了，cpu就会解决你的这个flag变量值马上就会用。缓存没有被淘汰。
        // 缓存淘汰之后，就可以保证可见性。
        // 本地缓存什么时候失效？
        //
        while (flag) {
            count++;
            //没有跳出循环 ， 可见性问题，
            // threadB修改了变量flag，而threadA不可见


            //UnsafeFactory.getUnsafe().storeFence();
            // 能够跳出循环，Thread.yield() 会释放时间片，上下文切换，再次处理的时候，会还原数据，那么当还原数据的时候，发现数据被修改了，那么就会重新加载，此时就可以跳出循环。
            //Thread.yield();
            //System.out.println(count);

            //JVM的内存模型：与GC有关的一块
            //JMM：java 内存模型 共享内存模型
            // 总的来说，是lock指令

        }
        System.out.println(Thread.currentThread().getName() + "跳出循环：count：" + count);
    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityTest visibilityTest = new VisibilityTest();

        Thread threadA = new Thread(() -> visibilityTest.load(), "threadA");
        threadA.start();

        Thread.sleep(1000);

        Thread threadB = new Thread(() -> visibilityTest.refresh(), "threadB");
        threadB.start();
    }


}
