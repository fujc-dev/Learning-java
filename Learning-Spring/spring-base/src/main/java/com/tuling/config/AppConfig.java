package com.tuling.config;

import com.tuling.condition.MyCondition;
import com.tuling.listener.MessageListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/10/8 13:55
 */
@Configuration
@Conditional(MyCondition.class)
@ComponentScan("com.tuling")
@PropertySource("classpath:spring.properties")
public class AppConfig {


}
