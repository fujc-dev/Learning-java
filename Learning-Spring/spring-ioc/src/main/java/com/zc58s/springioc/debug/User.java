package com.zc58s.springioc.debug;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/18 14:44
 */
public class User implements BeanNameAware {

    private String id;
    private String name;
    private String address;
    @Override
    public void setBeanName(String name) {
        this.id = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
