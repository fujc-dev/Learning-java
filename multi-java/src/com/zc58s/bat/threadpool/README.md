

#### 
```java
public class ThreadPoolExecutor extends AbstractExecutorService {
    
    
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
        //c 
        //offer 方法与add方法差不多一致
        if (isRunning(c) && workQueue.offer(command)) {
            int recheck = ctl.get();
            if (! isRunning(recheck) && remove(command))
                reject(command);
            else if (workerCountOf(recheck) == 0)
                addWorker(null, false);
        }
        else if (!addWorker(command, false))
            reject(command);
    }
}
```