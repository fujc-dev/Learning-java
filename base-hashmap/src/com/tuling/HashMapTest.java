package com.tuling;

import java.security.PublicKey;
import java.util.*;
import java.util.HashMap;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/15 16:07
 */
public class HashMapTest {
    public static void main(String[] args) {
        //数组，插入的时候，是按照顺序插入的，数组是特点：顺序插入，查询，修改效率高，非顺序插入，删除效率低。
        //非顺序插入会移位
        List list = new ArrayList();
        list.add(0, "1");
        list.add("2");

        //数组+链表，
        //插入效率高：
        //访问效率低：
        HashMap<String, String> maps = new HashMap<>();
        maps.put("1", "1");   // key ---> key.hashcode()---->
        maps.put("2", "2");

        //在多线程的时候，出错
        //ConcurrentModificationException fast fail
        for (String key : maps.keySet()) {
            if ("2".equals(key)) {
                maps.remove(key);
            }
        }
        //解决方案1：副本删除
        for (Map.Entry<String, String> key : maps.entrySet()) {
            if ("2".equals(key)) {
                maps.remove(key);
            }
        }
        //解决方案2：迭代器删除
        Iterator iterator = maps.keySet().iterator();
        while (iterator.hasNext()) {
            String key = String.valueOf(iterator.next());
            if ("2".equals(key)) {
                iterator.remove();
            }
        }

        int m = 0;
        int n = 0;
        System.out.println(m++);
        System.out.println(++n);
    }
}
