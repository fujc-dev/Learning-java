package com.zc58s.bat.threadpool;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/11/30 9:59
 */

public class MyTask implements Runnable {

    private int i;

    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "程序员做第" + this.i + "个项目");
        try {
            Thread.sleep(3000L);  //处理业务耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
