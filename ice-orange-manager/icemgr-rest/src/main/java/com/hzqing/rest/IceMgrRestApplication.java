package com.hzqing.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author 衡钊清
 * @classname IceMgrRestApplication
 * @description TODO
 * @date 2021-02-02 下午7:57
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.hzqing.rest", "com.hzqing.common.rest"})
public class IceMgrRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(IceMgrRestApplication.class, args);
    }

}
