package com.hzqing.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 衡钊清
 * @classname Test
 * @description TODO
 * @date 2021-02-06 上午11:14
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("IceMgr_UI"));
    }
}
