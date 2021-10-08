package com.tuling;

/**
 * @Author fujc
 * @Date: 2021/9/15 22:29
 * @Version 1.0
 */
public class Bean {
    public String name;
    public Bean next;

    public Bean() {
    }

    public Bean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", next=" + next.name +
                '}';
    }
}
