package com.tuling;

import com.tuling.config.AppConfig;
import com.tuling.events.MessageEvent;
import com.tuling.service.UserService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/10/8 13:54
 */
public class App {
    public static void main(String[] args) {

        //
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        context.publishEvent(new MessageEvent("234234"));


        //1、假如UserService没有添加@Component注解，可以通过硬编码的方式注入
        //构建BeanDefinition来实现注入
        /*AbstractBeanDefinition beanDefinition= BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(UserService.class);
        context.registerBeanDefinition("userService",beanDefinition);
         */

        //2、使用Reader来扫描
        /*
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
        reader.register(UserService.class);

         */

        //3、XML配置
       /*
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("classpath:spring.xml");
        UserService service = context.getBean("userService", UserService.class);
        service.test();

        */


       //操作系统环境变量
        /*
        Map<String, Object> systemEnvironment = context.getEnvironment().getSystemEnvironment();
        System.out.println(systemEnvironment);

        System.out.println("=======");
        //
        Map<String, Object> systemProperties = context.getEnvironment().getSystemProperties();
        System.out.println(systemProperties);

        System.out.println("=======");

        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
        System.out.println(propertySources);

        System.out.println("=======");

        System.out.println(context.getEnvironment().getProperty("NO_PROXY"));
        System.out.println(context.getEnvironment().getProperty("sun.jnu.encoding"));
        System.out.println(context.getEnvironment().getProperty("simple"));

         */
    }
}
