package com.tuling;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author fujc
 * @Date: 2021/9/16 19:59
 * @Version 1.0
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        //ConcurrentHashMap 构造函数
        //this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        //DEFAULT_CONCURRENCY_LEVEL 指的是segments个数
        ConcurrentHashMap<String,String> maps = new ConcurrentHashMap<>();
        maps.put("1","1");
        maps.put("2","2");

        for (String key:maps.keySet()){
            if("2".equals(key)){
                maps.remove(key);
            }
        }
    }
}
