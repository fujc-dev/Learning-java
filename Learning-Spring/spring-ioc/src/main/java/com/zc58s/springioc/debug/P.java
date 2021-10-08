package com.zc58s.springioc.debug;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/18 14:47
 */
public class P {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:user-bean.xml");
        //不使用ApplicationContext，使用感知接口获取我们想要的ApplicationContext对象
        //User user=context.getBean(User.class);
       //System.out.println(String.format("实现了BeanNameAware接口的信息BeanId=%s,所有信息=%s",user.getId(),user.toString()));

        User  user  =MyBeanFactory.getBean(User.class);
        System.out.println(String.format("实现了BeanNameAware接口的信息BeanId=%s,所有信息=%s",user.getId(),user.toString()));
    }
}
