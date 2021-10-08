package com.zc58s;

import com.zc58s.projects.IUserService;
import com.zc58s.projects.config.AppConfig;
import com.zc58s.projects.service.UserService;
import com.zc58s.spring.AnnotationConfigApplicationContext;
import com.zc58s.spring.exceptions.BeanNameNotFindException;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/6 9:55
 */
public class Programs {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        IUserService userService = null;
        try {
            userService = (IUserService) context.getBean("userService");
            userService.test();
        } catch (BeanNameNotFindException e) {
            e.printStackTrace();
        }

    }
}
