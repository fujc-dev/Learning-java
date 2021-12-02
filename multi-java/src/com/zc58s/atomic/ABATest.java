package com.zc58s.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;



/**
 * @author fjc.dane@gmail.com
 * @createtime : 2021/12/02
 */

public class ABATest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        new Thread(() -> {
            int value = atomicInteger.get();
            System.out.println("Thread1 read value: " + value);

            // 阻塞1s
            LockSupport.parkNanos(1000000000L);

            // Thread1通过CAS修改value值为3
            if (atomicInteger.compareAndSet(value, 3)) {
                System.out.println("Thread1 update from " + value + " to 3");
            } else {
                System.out.println("Thread1 update fail!");
            }
        }, "Thread1").start();

        new Thread(() -> {
            int value = atomicInteger.get();
            System.out.println("Thread2 read value: " + value);
            // Thread2通过CAS修改value值为2
            if (atomicInteger.compareAndSet(value, 2)) {
                System.out.println("Thread2 update from " + value + " to 2");

                // do something
                value = atomicInteger.get();
                System.out.println("Thread2 read value: " + value);
                // Thread2通过CAS修改value值为1
                if (atomicInteger.compareAndSet(value, 1)) {
                    System.out.println("Thread2 update from " + value + " to 1");
                }
            }
        }, "Thread2").start();
    }
}
