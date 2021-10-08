package com.zc58s.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc58s.springioc.core.FXNewsProvider;

public class P3 {

	/**
	 * 注解的方式注入
	 * <p>
	 * SpringBoot就推荐使用该方式：<br/>
	 * </p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 获取配置的包扫描对象
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:scaning.xml");
		FXNewsProvider provider = ctx.getBean(FXNewsProvider.class);
		provider.getAndPersistNews();
	}
}
