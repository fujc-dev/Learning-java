package com.tuling.jvm;

/**
 * <p>* 沙箱安全机制，自己写的java.lang.String.class类不会被加载，这样便可以防止核心API库被随意篡改</p>
 *
 * <p>*  避免类的重复加载，当父的ClassLoader已经加载了该类时，子的ClassLoader就没有必要再加载一次，保证被加载类的唯一性 </p>
 *
 * <p>*  全盘负责委托机制：指当前一个ClassLoader装载一个类时，除非显示的使用另外一个ClassLoader，否则该类型所依赖的类也由这个ClassLoader类载入。</p>
 *
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/10 16:06
 */
public class Math {

    public  static  int initData = 666;
    public  static  User user = new User();

    public int compute() {
        return 1;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }
}
