package com.tuling.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/10/8 15:21
 */
public class MessageEvent extends ApplicationEvent {
    public MessageEvent(Object source) {
        super(source);
    }

}
