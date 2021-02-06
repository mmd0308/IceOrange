package com.hzqing.modules.system.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.validation.constraints.NotNull;

/**
 * @author 衡钊清
 * @classname IceMgrSystemProvider
 * @description TODO
 * @date 2021-02-01 下午11:18
 */
@EnableDiscoveryClient
@SpringBootApplication
@NotNull
@MapperScan("com.hzqing.modules.system.provider.dal.mapper")
public class IceMgrSystemProvider {
    public static void main(String[] args) {
        new SpringApplicationBuilder(IceMgrSystemProvider.class).run(args);
    }
}
