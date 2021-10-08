package com.zc58s.springioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.zc58s.springioc.core.FXNewsProvider;

public class P2 {

	/**
	 * XML的形式构建注入
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Bean工厂与Bean定义容器的默认实现
		DefaultListableBeanFactory registeryBeanFactory = new DefaultListableBeanFactory();
		// XmlBeanDefinitionReader reader = new
		// XmlBeanDefinitionReader(registeryBeanFactory);
		// reader.loadBeanDefinitions("classpath:ioc.xml");
		// 该方式还是过时的，当前版本是Spring5.x
		registeryBeanFactory = new XmlBeanFactory(new ClassPathResource("ioc.xml"));
		FXNewsProvider provider = (FXNewsProvider) registeryBeanFactory.getBean("djNewProvider");
		provider.getAndPersistNews();

	}

}
