package com.tuling.jvm;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/10 16:16
 */
public class User {

    private int id;
    private String name;


    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        //被回收会执行finalize
        //System.out.println("GC，" + "User{" + "id=" + id + ", name='" + name + '\'' + '}');
    }

}
