package com.tuling.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/15 11:28
 */
public class OOMTest {

    public static List<Object> list = new ArrayList<>();


    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
            new User(j--, UUID.randomUUID().toString());
        }
    }
}
