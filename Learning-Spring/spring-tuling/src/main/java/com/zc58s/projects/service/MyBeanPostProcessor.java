package com.zc58s.projects.service;

import com.zc58s.spring.BeanPostProcessor;
import com.zc58s.spring.annotation.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/6 14:15
 */
@Component()
public class MyBeanPostProcessor implements BeanPostProcessor {


    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("beanName：" + beanName);
        //
        if (beanName.equals("userService")) {
            Object proxyInstance = Proxy.newProxyInstance(MyBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // 切面
                    System.out.println("切面");
                    return method.invoke(bean, args);
                }
            });
            return proxyInstance;
        }
        return bean;
    }
}
