package com.zc58s.springioc.debug;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/18 14:56
 */
public class MyBeanFactory implements BeanFactoryAware {

    private static BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public static  <T> T getBean(Class<T> classType) {
        if (beanFactory == null) {
            return null;
        }
        return beanFactory.getBean(classType);
    }
}
