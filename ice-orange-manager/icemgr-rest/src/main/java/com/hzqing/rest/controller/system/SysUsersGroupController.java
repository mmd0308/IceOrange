package com.hzqing.rest.controller.system;

import com.hzqing.common.constants.GlobalConstants;
import com.hzqing.core.web.controller.BaseController;
import com.hzqing.system.dal.entity.SysUsersGroups;
import com.hzqing.system.service.ISysUserGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 衡钊清
 * @classname SysUserController
 * @description 系统用户信息
 * @date 2020/7/22 21:04
 */
@RestController
@RequestMapping(GlobalConstants.SYSTEM_BATH_V1 + "/users/groups")
public class SysUsersGroupController extends BaseController<ISysUserGroupsService, SysUsersGroups> {

    @Autowired
    private ISysUserGroupsService userGroupsService;

//    @PostMapping
//    public void add(@RequestBody SysUser user) {
//        userService.add(user);
//    }

}
