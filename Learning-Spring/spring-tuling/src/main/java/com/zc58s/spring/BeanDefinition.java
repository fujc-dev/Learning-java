package com.zc58s.spring;

import com.zc58s.spring.enums.ScopeType;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/6 13:12
 */
public class BeanDefinition {
    private Class type;
    private String beanName;
    private ScopeType scope;
    private boolean isLazy;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public ScopeType getScope() {
        return scope;
    }

    public void setScope(ScopeType scope) {
        this.scope = scope;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }
}
