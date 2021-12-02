package com.zc58s.atomic;

import java.util.concurrent.atomic.AtomicReference;



/**
 * @author fjc.dane@gmail.com
 * @createtime : 2021/12/02
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        User user1 = new User("张三", 23);
        User user2 = new User("李四", 25);
        User user3 = new User("王五", 20);

        //初始化为 user1
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(user1);

        //把 user2 赋给 atomicReference
        atomicReference.compareAndSet(user1, user2);
        System.out.println(atomicReference.get());

        //把 user3 赋给 atomicReference
        atomicReference.compareAndSet(user1, user3);
        System.out.println(atomicReference.get());

    }

}


class User {
    private String name;
    private Integer age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
