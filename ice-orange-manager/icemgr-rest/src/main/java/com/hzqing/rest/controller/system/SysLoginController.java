package com.hzqing.rest.controller.system;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 衡钊清
 * @classname SysLoginController
 * @description TODO
 * @date 2020-07-29 19:25
 */
@RestController
@RequestMapping("/api/login")
public class SysLoginController {

    @PostMapping
    public String login(){
        return "xxx";
    }
}
