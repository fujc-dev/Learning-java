package com.tuling;

import com.tuling.config.AppConfig;
import com.tuling.events.MessageEvent;
import com.tuling.service.UserService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/10/8 13:54
 */
public class App {
    public static void main(String[] args) {

        Execute execute = new Execute();
        // new AnnotationConfigApplicationContext时做了那些事情？
        /**
         * 提前：
         * 1、new AnnotationConfigApplicationContext就是创建容器，然后将Bean、BeanDefinition构建到容器中；
         * 2、我们构建Bean有3中方式，代码构建注解的方式、Xml配置，而AnnotationConfigApplicationContext就是编码的方式创建容器，构建Bean；
         * 总结：
         *      AnnotationConfigApplicationContext构造函数里面初始化了一个reader、scanner；
         *      reader就是以编程的方式；
         *      scanner就是已扫描.class文件，准确一点就是扫描Component、Server、Bean、Repository、Condition等Spring声明的注解。
         *
         *
         */
        //new AnnotationConfigApplicationContext(AppConfig.class); 做了那些事情？
        // 1、扫描，构建BeanDefinition
        // 2、实例化非懒加载的单例Bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = (UserService) context.getBean("userService");

        userService.test();

        context.publishEvent(new MessageEvent("234234"));

        ProxyFactory proxyFactory = new ProxyFactory();
        //proxyFactory.setTarget();


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
