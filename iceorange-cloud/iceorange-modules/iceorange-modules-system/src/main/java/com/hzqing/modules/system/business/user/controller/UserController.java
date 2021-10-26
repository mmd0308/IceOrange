package com.hzqing.modules.system.business.user.controller;

import com.hzqing.common.core.base.controller.BaseController;
import com.hzqing.modules.system.business.user.entity.SysUser;
import com.hzqing.modules.system.business.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 衡钊清
 * @classname UserController
 * @description TODO
 * @date 2021-10-26 下午10:10
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<SysUser, UserService> {

}
