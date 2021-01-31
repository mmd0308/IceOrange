package com.hzqing.rest.controller.system;

import com.hzqing.common.constants.GlobalConstants;
import com.hzqing.core.web.controller.BaseController;
import com.hzqing.system.dal.entity.SysRole;
import com.hzqing.system.service.ISysRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 衡钊清
 * @Classname SysRoleController
 * @Description 角色管理
 * @Date 2020-07-24 23:11
 */
@RestController
@RequestMapping("/system" + GlobalConstants.VERSION_V1 + "/roles")
public class SysRoleController extends BaseController<ISysRoleService, SysRole> {
}
