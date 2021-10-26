package com.hzqing.modules.system.business.log.service.impl;

import com.hzqing.common.core.base.service.impl.BaseServiceImpl;
import com.hzqing.modules.system.business.log.entity.SysLoginLog;
import com.hzqing.modules.system.business.log.mapper.LoginLogMapper;
import com.hzqing.modules.system.business.log.service.LoginLogService;
import org.springframework.stereotype.Service;

/**
 * @author 衡钊清
 * @classname LoginLogServiceImpl
 * @description 登陆日志业务实现类
 * @date 2021-10-26 下午10:21
 */
@Service
public class LoginLogServiceImpl extends BaseServiceImpl<SysLoginLog, LoginLogMapper> implements LoginLogService {
}
