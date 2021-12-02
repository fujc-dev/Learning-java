

##### LongAdder 源码
```java
class  LongAdder{

    /**
     * Long类型数据的cas操作
     * @param x
     */
    public void add(long x) {
        Cell[] as; long b, v; int m; Cell a;
        //as：这个变量就来声明当前内核的槽的
        if ((as = cells) != null || !casBase(b = base, b + x)) {
            boolean uncontended = true;
            if (as == null || (m = as.length - 1) < 0 ||
                    (a = as[getProbe() & m]) == null ||
                    !(uncontended = a.cas(v = a.value, v + x)))
                longAccumulate(x, null, uncontended);
        }
    }
}
```