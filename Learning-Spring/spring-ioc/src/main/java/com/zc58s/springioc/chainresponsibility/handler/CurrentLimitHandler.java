package com.zc58s.springioc.chainresponsibility.handler;

import com.zc58s.springioc.chainresponsibility.service.GatewayHandler;

/**
 * 限流判断
 *
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/23 11:56
 */
public class CurrentLimitHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("第一链");
        super.nextService();
    }
}
