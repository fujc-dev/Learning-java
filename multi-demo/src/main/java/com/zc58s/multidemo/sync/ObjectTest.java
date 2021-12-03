package com.zc58s.multidemo.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * 关闭指针压缩（-XX:-UseCompressedOops）
 */
public class ObjectTest {

    public static void main(String[] args) throws InterruptedException {
        //jvm 延迟偏向，直接开启匿名偏向状态，我们可以看到内存布局全部都变成偏向锁
        //但是，我们的第一个obj是属于主线程的，为什么会是偏向锁呢？
        //那么，这里涉及到一个概念，当我们开启偏向锁模式的时候，默认对象全部都开启偏向锁模式，
        // 这些新建的对象，还没有指定我们偏向的线程，也就是说，真正有线程竞争的时候
        //例如：Object obj = new Object();  00000101 00000000 00000000 00000000 ，此时全是为0
        Thread.sleep(5000);  //
        Object obj = new Object();
        //obj.hashCode();
        //在新建对象后，我们调用了hashCode，此时偏向锁撤销，如果有线程竞争到这个锁对象时，会编程轻量级锁
        //查看对象内部信息
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        new Thread(() -> {
            synchronized (obj) {
                //如果在此处，调用了obj.hashCode()，此时进行偏向锁撤销
                //锁会变成重量级锁
                //如果在此处调用了obj.wait(100)，此时进行偏向锁撤销，wait会执行锁清除
                //锁会变成重量级锁
                //如果在此处调用了obj.notify()，此时进行偏向锁撤销
                //锁会变成重量轻量级锁
                System.out.println(Thread.currentThread().getName() + " \n " + ClassLayout.parseInstance(obj).toPrintable());
            }
        }, "Thread1").start();

        new Thread(() -> {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + " \n " + ClassLayout.parseInstance(obj).toPrintable());
            }
        }, "Thread2").start();
    }
}

