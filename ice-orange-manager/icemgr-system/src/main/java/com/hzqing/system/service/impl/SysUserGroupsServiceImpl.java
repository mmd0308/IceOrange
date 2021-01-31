package com.hzqing.system.service.impl;

import com.hzqing.common.provider.service.impl.BaseServiceImpl;
import com.hzqing.system.dal.entity.SysUsersGroups;
import com.hzqing.system.dal.mapper.SysUsersGroupsMapper;
import com.hzqing.system.service.ISysUserGroupsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 衡钊清
 * @Classname SysUserServiceImpl
 * @Description 用户管理 业务实现
 * @Date 2020/7/22 20:40
 */
@Slf4j
@Service
public class SysUserGroupsServiceImpl extends BaseServiceImpl<SysUsersGroupsMapper, SysUsersGroups> implements ISysUserGroupsService {

    @Autowired
    private SysUsersGroupsMapper usersGroupsMapper;
}
