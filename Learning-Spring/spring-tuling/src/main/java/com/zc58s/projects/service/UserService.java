package com.zc58s.projects.service;

import com.zc58s.projects.IUserService;
import com.zc58s.spring.BeanNameAware;
import com.zc58s.spring.annotation.Autowired;
import com.zc58s.spring.enums.ScopeType;
import com.zc58s.spring.annotation.Component;
import com.zc58s.spring.annotation.Scope;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/6 11:29
 */
@Component("userService")
@Scope(value = ScopeType.prototype)
public class UserService implements IUserService, BeanNameAware {

    @Autowired
    private OrderService orderService;

    public void test() {
        System.out.println("123");
    }

    public void afterPropertiesSet() {
        System.out.println("初始化");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("我收到了Spring框架返回给我BeanNam：" + name);
    }
}
