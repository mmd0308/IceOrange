package com.hzqing.explorer.service.impl;

import com.hzqing.common.provider.service.impl.BaseServiceImpl;
import com.hzqing.explorer.dal.entity.ExpDateType;
import com.hzqing.explorer.dal.mapper.ExpDateTypeMapper;
import com.hzqing.explorer.service.ExpDateTypeService;
import org.springframework.stereotype.Service;

/**
 * @author 衡钊清
 * @Classname ExpDateTypeServiceImpl
 * @Description 数据类型 业务层实现
 * @Date 2020/7/24 22:37
 */
@Service
public class ExpDateTypeServiceImpl extends BaseServiceImpl<ExpDateTypeMapper, ExpDateType> implements ExpDateTypeService {
}
