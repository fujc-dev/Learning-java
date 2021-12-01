#### 线程池

```java
public class ThreadPoolExecutor extends AbstractExecutorService {


    /**
     *  执行 ，执行优先级，
     * @param command
     */
    public void execute(Runnable command) {
        if (command == null)
            throw new NullPointerException();

        //ctl CAS
        int c = ctl.get();
        //workerCountOf 正式工是否有空余人员
        if (workerCountOf(c) < corePoolSize) {
            //有空余的正式工，就使用addWorker方法，创建Worker对象，Worker里面封装了Thread，
            //创建一个新的线程，此时创建的是核心线程（正式工）。
            //
            if (addWorker(command, true))
                return;
            c = ctl.get();
        }
        // 向队列里面放，而列队长度为10，队列容量为10
        //offer 方法与add方法差不多一致，放不成功，返回false
        //isRunning(c) 
        if (isRunning(c) && workQueue.offer(command)) {
            int recheck = ctl.get();
            if (!isRunning(recheck) && remove(command))
                //拒绝策略
                reject(command);
            else if (workerCountOf(recheck) == 0)
                //为什么会传一个空任务？
                //
                addWorker(null, false);
        }
        //临时工处理的地方，案例中的临时工的Size为10
        else if (!addWorker(command, false))
            //拒绝策略
            reject(command);
    }


    private static int workerCountOf(int c) {
        // & ：与，c与CAPACITY值都为1，返回true，两个值相等才成功
        return c & CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
       // |：或，正好和与相反，只要有一个值是1，那么就返回成功
        return rs | wc;
    }
}
    //非运算符用符号“~”表示，其运算规律如下：如果位为0，结果是1，如果位为1，结果是0，下面看一个简单例子。

    //异或运算符是用符号“^”表示的，其运算规律是：两个操作数的位中，相同则结果为0，不同则结果为1。下面看一个简单的例子。
```