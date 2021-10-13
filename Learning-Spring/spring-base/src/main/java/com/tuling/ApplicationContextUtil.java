package com.tuling;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/10/13 10:11
 */
@Component
public class ApplicationContextUtil  implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
