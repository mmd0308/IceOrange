package com.hzqing.modules.system.provider.service;

import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.core.constants.IceVersionConstants;
import com.hzqing.modules.system.api.dto.CreateUserGroupRequest;
import com.hzqing.modules.system.api.service.IceUserGroupService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author 衡钊清
 * @Classname SysUserServiceImpl
 * @Description 用户管理 业务实现
 * @Date 2020/7/22 20:40
 */
@DubboService(version = IceVersionConstants.SERVER_VERSION_V10)
public class IceUserGroupServiceImpl implements IceUserGroupService {


    @Override
    public void create(CreateUserGroupRequest request) {

    }

    @Override
    public void removeById(IDRequest request) {

    }
}
