package com.hzqing.modules.system.provider.service;

import com.hzqing.common.core.constants.IceVersionConstants;
import com.hzqing.modules.system.api.service.SysRolesService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 衡钊清
 * @Classname SysRoleServiceImpl
 * @Description 系统角色 业务层实现类
 * @Date 2020/7/24 21:40
 */
@DubboService(version = IceVersionConstants.SERVER_VERSION_V10)
public class SysRolesServiceImpl implements SysRolesService {
}
