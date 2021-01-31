package com.hzqing.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 衡钊清
 * @Classname IceOrangeApplication
 * @Description 项目启动
 * @Date 2020/7/22 20:56
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.hzqing"})
public class IceOrangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(IceOrangeApplication.class, args);
    }
}
