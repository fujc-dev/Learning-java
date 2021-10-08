package com.zc58s;

import com.zc58s.projects.config.AppConfig;
import com.zc58s.spring.AnnotationConfigApplicationContext;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/10/8 13:31
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
    }
}
