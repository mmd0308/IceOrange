package com.hzqing.explorer.service.impl;

import com.hzqing.common.provider.service.impl.BaseServiceImpl;
import com.hzqing.explorer.dal.entity.ExpApis;
import com.hzqing.explorer.dal.mapper.ExpApisMapper;
import com.hzqing.explorer.service.ExpApisService;
import org.springframework.stereotype.Service;

/**
 * @author 衡钊清
 * @classname ExpApisServiceImpl
 * @description api 管理 业务实现
 * @date 2020-08-02 09:23
 */
@Service
public class ExpApisServiceImpl extends BaseServiceImpl<ExpApisMapper, ExpApis> implements ExpApisService {
}
