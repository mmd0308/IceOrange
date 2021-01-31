package com.hzqing.system.service.impl;

import com.hzqing.common.provider.service.impl.BaseServiceImpl;
import com.hzqing.system.dal.entity.SysResources;
import com.hzqing.system.dal.mapper.SysResourcesMapper;
import com.hzqing.system.service.ISysResourcesService;
import org.springframework.stereotype.Service;

/**
 * @author 衡钊清
 * @Classname SysResourcesServiceImpl
 * @Description 资源管理 业务层实现
 * @Date 2020/7/24 21:39
 */
@Service
public class SysResourcesServiceImpl extends BaseServiceImpl<SysResourcesMapper, SysResources> implements ISysResourcesService {
}
