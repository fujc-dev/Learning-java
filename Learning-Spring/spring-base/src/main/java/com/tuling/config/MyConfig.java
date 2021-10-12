package com.tuling.config;

import com.tuling.bean.Apple;
import com.tuling.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/10/12 15:41
 */
@Configuration
@Import(Apple.class)
@Scope
public class MyConfig {
    @Bean
    public Student student(){
        return new Student();
    }

}
