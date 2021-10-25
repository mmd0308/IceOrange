package com.hzqing.modules.system.business.role.controller;

import com.hzqing.common.core.base.controller.BaseController;
import com.hzqing.modules.system.business.role.dto.SysRoleDto;
import com.hzqing.modules.system.business.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 衡钊清
 * @classname RoleController
 * @description 角色管理
 * @date 2021-10-25 下午10:17
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<SysRoleDto, RoleService> {

}
