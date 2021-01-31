package com.hzqing.rest.system;

import com.hzqing.common.constants.GlobalConstants;
import com.hzqing.system.dal.entity.SysUser;
import com.hzqing.system.service.ISysUserService;
import com.hzqing.core.web.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 衡钊清
 * @Classname SysUserController
 * @Description 系统用户信息
 * @Date 2020/7/22 21:04
 */
@RestController
@RequestMapping("/system" + GlobalConstants.VERSION_V1 + "/users")
public class SysUserController extends BaseController<ISysUserService, SysUser> {

}
