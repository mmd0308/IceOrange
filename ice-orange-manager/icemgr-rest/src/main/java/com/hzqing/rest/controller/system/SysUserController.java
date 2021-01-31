package com.hzqing.rest.controller.system;

import com.hzqing.common.constants.GlobalConstants;
import com.hzqing.system.dal.entity.SysUser;
import com.hzqing.system.service.ISysUserService;
import com.hzqing.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 衡钊清
 * @classname SysUserController
 * @description 系统用户信息
 * @date 2020/7/22 21:04
 */
@RestController
@RequestMapping(GlobalConstants.SYSTEM_BATH_V1+ "/users")
public class SysUserController extends BaseController<ISysUserService, SysUser> {

    @Autowired
    private ISysUserService userService;

//    @PostMapping
//    public void add(@RequestBody SysUser user) {
//        userService.add(user);
//    }

}
