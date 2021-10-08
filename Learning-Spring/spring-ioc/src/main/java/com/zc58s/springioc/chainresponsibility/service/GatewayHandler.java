package com.zc58s.springioc.chainresponsibility.service;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/23 11:54
 */
public abstract class GatewayHandler {

    protected GatewayHandler next;

    public abstract void service();

    public void setNext(GatewayHandler next) {
        this.next = next;
    }

    protected void nextService() {
        if (this.next != null) {
            this.next.service();
        }
    }
}
