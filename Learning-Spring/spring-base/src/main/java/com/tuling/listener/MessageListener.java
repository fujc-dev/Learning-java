package com.tuling.listener;

import com.tuling.events.MessageEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/10/8 15:24
 */
@Component
public class MessageListener implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof MessageEvent) {
            MessageEvent event = (MessageEvent) applicationEvent;
            System.out.println(event.toString());
        } else {
            AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) applicationEvent.getSource();
            System.out.println("ApplicationEvent Class Name:" + applicationEvent.getSource().getClass().getName());
            System.out.println("容器中初始化Bean数量:" + context.getBeanDefinitionCount());
        }

    }
}
