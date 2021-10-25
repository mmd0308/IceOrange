package com.hzqing.modules.system.business.role.service.impl;

import com.hzqing.common.core.base.service.impl.BaseServiceImpl;
import com.hzqing.modules.system.business.role.dal.entity.SysRole;
import com.hzqing.modules.system.business.role.dal.mapper.SysRoleMapper;
import com.hzqing.modules.system.business.role.dto.SysRoleDto;
import com.hzqing.modules.system.business.role.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author 衡钊清
 * @classname RoleServiceImpl
 * @description TODO
 * @date 2021-10-25 下午10:21
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<SysRoleDto, SysRole, SysRoleMapper> implements RoleService {
}
