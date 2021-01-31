package com.hzqing.common.provider.system.service.impl;

import com.hzqing.common.provider.service.impl.BaseServiceImpl;
import com.hzqing.common.provider.system.dal.entity.SysUser;
import com.hzqing.common.provider.system.dal.mapper.SysUserMapper;
import com.hzqing.common.provider.system.service.ISysUserService;
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
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;
}
