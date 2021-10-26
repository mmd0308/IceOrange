package com.hzqing.modules.system.business.user.service.impl;

import com.hzqing.common.core.base.service.impl.BaseServiceImpl;
import com.hzqing.modules.system.business.user.entity.SysUser;
import com.hzqing.modules.system.business.user.mapper.UserMapper;
import com.hzqing.modules.system.business.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 衡钊清
 * @classname UserServiceImpl
 * @description 用户服务业务实现
 * @date 2021-10-26 下午10:14
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<SysUser, UserMapper> implements UserService {
}
