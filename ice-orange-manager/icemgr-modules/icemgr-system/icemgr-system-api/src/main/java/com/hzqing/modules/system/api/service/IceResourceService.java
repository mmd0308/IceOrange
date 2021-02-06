package com.hzqing.modules.system.api.service;

import com.hzqing.common.api.request.IDRequest;
import com.hzqing.modules.system.api.dto.CreateResourceRequest;

/**
 * @author 衡钊清
 * @Classname ISysResourcesService
 * @Description 资源管理 业务层接口
 * @Date 2020/7/24 21:03
 */
public interface IceResourceService {

    void create(CreateResourceRequest request);

    void removeById(IDRequest request);

}
