package com.zc58s.springioc.debug;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/18 14:50
 */
public class MyApplicationContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static  <T> T getBean(Class<T> classType) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(classType);
    }
}
