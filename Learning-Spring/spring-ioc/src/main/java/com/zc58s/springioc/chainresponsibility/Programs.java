package com.zc58s.springioc.chainresponsibility;

import com.zc58s.springioc.chainresponsibility.service.GatewayHandler;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/23 13:12
 */
public class Programs {
    public static void main(String[] args) {
        GatewayHandler gatewayHandler = Context.getHandler();
        gatewayHandler.service();
    }
}
