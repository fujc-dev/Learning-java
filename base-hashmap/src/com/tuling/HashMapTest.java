package com.tuling;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/15 16:07
 */
public class HashMapTest {
    public static void main(String[] args) {
        //数组，插入的时候，是按照顺序插入的，数组是特点：顺序插入，查询，修改效率高，非顺序插入，删除效率低。
        List list = new ArrayList();
        list.add(0, "1");
        list.add("2");

        //数组+链表，
        //插入效率高：
        //访问效率低：
        HashMap<String, String> maps = new HashMap<>();
        String result = maps.put("1", "LiLei");   // key ---> key.hashcode()---->
        System.out.println(result);
        maps.get("1");

        int m = 0;
        int n = 0;
        System.out.println(m++);
        System.out.println(++n);
    }
}
