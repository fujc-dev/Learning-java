package com.zc58s.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/6 10:00
 */
@Target(ElementType.TYPE)  //类上面
@Retention(RetentionPolicy.RUNTIME)  //运行时
public @interface ComponentScan {
    String value() default "";
}
