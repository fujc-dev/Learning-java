#### 并发编程之深入理解Java线程

```text
    理解线程和进程以及进程间通信方式
    上下文切换
    为什么说java线程创建方式本质上只有一种
    Java线程实现原理以及Thread.start()源码分析
    Java线程调度机制分析
    操作系统底层&Java层面线程生命周期详解
    Thread常用方法使用及其注意事项
    利用线程中断机制如果优雅的终止进程
    Java线程间多种通信方法实现
```

#### 课前思考问题

```text
 1.CAS涉及到用户模式到内核模式的切换吗？ 
 2.为什么说创建Java线程的方式本质上只有一种？Java线程和go语言的协程有什么区别(为什么涉及到的高并发产品很多都是go语言写的)？ 
 3.如何优雅的终止线程？
 4.Java线程之间如何通信的，有哪些方式？
```

#### 操作系统层面线程状态

```text
初始状态、可运行状态、运行状态、休眠状态和终止状态。
```

#### JAVA层面的线程状态

```text
NEW
RUNNABLE
BLOCKED：阻塞，synchronized，竞争没有拿到锁，
WAITING：等待，wait，join
TIMED_WAITING：超时等待，参数里面弄一个超时的值
TERMINATED：终止
```

#### 创建线程的方式

````java
//最普通的创建线程的方式
public class Thread {

}

//任务和线程隔离，我们处理的逻辑与线程的创建分开
//缺点：无返回值，无法进行异常捕获，
public interface Runnable {

    //问题：
    //1、没有返回值
    //2、没有抛出异常，
    public abstract void run();
}

//在Runnable的基础上升级的版本
//使用Callable就没有那么简单了
//也可以通过创建FutureTask创建任务的方式
//也可以结合我们的线程池来使用
public interface Callable<V> {
    //
    V call() throws Exception;
}

//    new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

````

#### 线程创建和启动的流程总结

```text
  1）使用new Thread()创建一个线程，然后调用start()方法进行java层面的线程启动；
  2）调用本地方法start0()，去调用jvm中的JVM_StartThread方法进行线程创建和启动；
  3）调用new JavaThread(&amp;thread_entry, sz)进行线程的创建，并根据不同的操作系统平台调用对应的os::create_thread方法进行线程创建；
  4）新创建的线程状态为Initialized，调用了sync-&gt;wait()的方法进行等待，等到被唤醒才继续执行thread-&gt;run();
  5）调用Thread::start(native_thread);方法进行线程启动，此时将线程状态设置为RUNNABLE，接着调用os::start_thread(thread)，根据不同的操作系统选择不同的线程启动方式；
  6）线程启动之后状态设置为RUNNABLE, 并唤醒第4步中等待的线程，接着执行thread-&gt;run()的方法；
  7）JavaThread::run()方法会回调第1步new Thread中复写的run()方法。
```

#### 线程中断

```text
中断标志位
注：有些操作会清除标志位
```

#### Java线程间通信

```text
 等待通知机制，等待唤醒机制
```