package com.zc58s.springioc.chainresponsibility.handler;

import com.zc58s.springioc.chainresponsibility.service.GatewayHandler;

/**
 * 黑名单处理判断
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/23 11:56
 */
public class BlacklistHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("第二链");
        super.nextService();
    }
}
