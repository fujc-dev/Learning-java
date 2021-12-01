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
}
```