package com.zc58s.springioc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class SpringIocApplicationTests {

	@Test
	void contextLoads() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:ioc2.xml");
		if(ctx!=null) {
			ctx.close();	
		}
		
	}

}
