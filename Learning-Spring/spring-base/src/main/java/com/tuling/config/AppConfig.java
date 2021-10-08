package com.tuling.config;

import com.tuling.listener.MessageListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/10/8 13:55
 */
@Component
@ComponentScan("com.tuling")
@PropertySource("classpath:spring.properties")
public class AppConfig {


}
