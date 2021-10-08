package com.zc58s.springioc.debug;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 手动的控制接管对象的创建
 *
 * <p>
 * 当需要进行特殊的初始化操作时，可以使用  {@link FactoryBean}接口，来进行实现
 * </p>
 *
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/10 15:26
 */
public class Cat implements FactoryBean<Cat> {
    @Override
    public Cat getObject() throws Exception {
        //自定义对象的创建逻辑，想怎么实现就怎么实现。不需要经过不需要经过标准处理流程。
        return new Cat();
    }

    @Override
    public Class<?> getObjectType() {
        return Cat.class;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("classpath:ioc.xml");
        Cat cat = cxt.getBean(Cat.class);

    }

}
