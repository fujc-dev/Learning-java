package com.tuling.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/10/14 14:33
 */
@Component
public class TuLingFactoryBean implements FactoryBean {

    public Object getObject() throws Exception {
        return new User();
    }


    public Class<?> getObjectType() {
        return User.class;
    }
}
