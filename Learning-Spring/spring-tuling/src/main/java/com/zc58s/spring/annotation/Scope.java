package com.zc58s.spring.annotation;

import com.zc58s.spring.enums.ScopeType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/6 11:31
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Scope {
    ScopeType value()  default  ScopeType.singleton;
}
