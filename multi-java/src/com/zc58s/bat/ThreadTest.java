package com.zc58s.bat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/11/30 9:21
 */

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
            thread.start();
            thread.join(); //等待线程执行完毕，执行主线程代码
        }
        System.out.println("时间：" + (System.currentTimeMillis() - start));
        System.out.println("大小：" + list.size());
        //资源创建耗时
    }

}
