package com.zc58s.springioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;;


/**
 *
 * 引入场景分析：
 *
 * <p>
 * 有一个FX（外汇交易）项目，经常需要近乎实时的位客户提供外汇新闻，通常情况下，都是先从不停<br/>
 * 的新闻社请阅新闻来源，然后通过批处理程序定时地到指定的新闻服务器抓取最新的外汇新闻，接着<br/>
 * 将这些新闻存储本地数据库，最后在FX系统的前台界面显示。<br/>
 * </p>
 *
 * @ClassName  SpringIocApplication
 * @Description TODO
 * @author fjc.dane@gmail.com
 * @date  2021年7月26日 上午11:56:23
 *
 */
@SpringBootApplication
public class SpringIocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIocApplication.class, args);
	}



}
