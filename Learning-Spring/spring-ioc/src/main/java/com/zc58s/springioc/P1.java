package com.zc58s.springioc;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import com.zc58s.springioc.core.FXNewsProvider;
import com.zc58s.springioc.core.service.listener.impl.DowJonesNewsListener;
import com.zc58s.springioc.core.service.persister.impl.DowJonesNewsPersister;

public class P1 {

	/**
	 * 以编码的方式进行依赖注入
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// DefaultListableBeanFactory
		// 是BeanFactory的默认实现，该类实现了BeanDefinitionRegistry，BeanFactory接口
		DefaultListableBeanFactory registery = new DefaultListableBeanFactory();
		// Bean定义
		AbstractBeanDefinition newProvider = new RootBeanDefinition(FXNewsProvider.class);
		AbstractBeanDefinition newListener = new RootBeanDefinition(DowJonesNewsListener.class);
		AbstractBeanDefinition newPersister = new RootBeanDefinition(DowJonesNewsPersister.class);
		// 将Bean定义置入Spring容器中
		registery.registerBeanDefinition("djNewProvider", newProvider);
		registery.registerBeanDefinition("djNewListener", newListener);
		registery.registerBeanDefinition("djNewPersister", newPersister);
		// 指定依赖关系
		// ConstructorArgumentValues values = new ConstructorArgumentValues();
		// values.addIndexedArgumentValue(0, newListener);
		// values.addIndexedArgumentValue(1, newPersister);
		// newProvider.setConstructorArgumentValues(values);
		// FXNewsProvider provider = (FXNewsProvider)
		// registery.getBean("djNewProvider");
		// provider.getAndPersistNews();

		// 属性注入
		
		

		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue("listener", newListener);
		propertyValues.addPropertyValue("persister", newPersister);
		newProvider.setPropertyValues(propertyValues);
		FXNewsProvider provider = (FXNewsProvider) registery.getBean("djNewProvider");
		provider.getAndPersistNews();
	}
}
