package com.zc58s.springioc.chainresponsibility;

import com.zc58s.springioc.chainresponsibility.handler.BlacklistHandler;
import com.zc58s.springioc.chainresponsibility.handler.ConversationHandler;
import com.zc58s.springioc.chainresponsibility.handler.CurrentLimitHandler;
import com.zc58s.springioc.chainresponsibility.service.GatewayHandler;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/23 11:57
 */
public class Context {
    public static GatewayHandler getHandler() {
        GatewayHandler currentLimitHandler = new CurrentLimitHandler();
        GatewayHandler blackListHandler  = new BlacklistHandler();
        currentLimitHandler.setNext(blackListHandler);
        GatewayHandler conversationHandler  = new ConversationHandler();
        blackListHandler.setNext(conversationHandler);
        return currentLimitHandler;
    }
}
