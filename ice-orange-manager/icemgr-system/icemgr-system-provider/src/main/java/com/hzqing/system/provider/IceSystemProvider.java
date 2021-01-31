package com.hzqing.system.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 系统服务
 *
 * @author hzqing
 * @date 2021/1/31 17:30
 **/
@SpringBootApplication
@MapperScan("com.hzqing.system.provider.dal.mapper")
public class IceSystemProvider {

    public static void main(String[] args) {
        SpringApplication.run(IceSystemProvider.class, args);
    }
}
