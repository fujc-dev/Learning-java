package com.zc58s.spring;

/**
 * 针对所有的Bean的，创建Bean的执行前，执行后做那些事情
 *
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/6 14:13
 */
public interface BeanPostProcessor {

    default Object postProcessBeforeInitialization(Object bean, String beanName) {
        return null;
    }

    default Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
