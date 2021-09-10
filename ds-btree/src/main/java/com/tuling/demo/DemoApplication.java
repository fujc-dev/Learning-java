package com.tuling.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    /**
     * 计算机组成原理。IO从磁盘读一次会读多少数据，PPage的，页，4k。
     *
     * <p>
     *     int占多少空间？4 byte
     * </p>
     *
     * <p>
     *     搜索效率，磁盘IO
     * </p>
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
