package com.hzqing.system.service.impl;

import com.hzqing.common.provider.service.impl.BaseServiceImpl;
import com.hzqing.system.dal.entity.SysRole;
import com.hzqing.system.dal.mapper.SysRoleMapper;
import com.hzqing.system.service.ISysRoleService;
import org.springframework.stereotype.Service;

/**
 * @author 衡钊清
 * @Classname SysRoleServiceImpl
 * @Description 系统角色 业务层实现类
 * @Date 2020/7/24 21:40
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
}
