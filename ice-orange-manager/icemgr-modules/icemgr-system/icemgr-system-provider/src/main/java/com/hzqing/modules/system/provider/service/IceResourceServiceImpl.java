package com.hzqing.modules.system.provider.service;

import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.core.constants.IceVersionConstants;
import com.hzqing.modules.system.api.dto.CreateResourceRequest;
import com.hzqing.modules.system.api.service.IceResourceService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author 衡钊清
 * @Classname SysResourcesServiceImpl
 * @Description 资源管理 业务层实现
 * @Date 2020/7/24 21:39
 */
@Service(version = IceVersionConstants.SERVER_VERSION_V10)
public class IceResourceServiceImpl implements IceResourceService {
    @Override
    public void create(CreateResourceRequest request) {

    }

    @Override
    public void removeById(IDRequest request) {

    }
}
