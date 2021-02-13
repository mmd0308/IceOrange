package com.hzqing.modules.system.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.api.response.CommonResponse;
import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.common.core.constants.IceVersionConstants;
import com.hzqing.common.provider.service.impl.BaseServiceImpl;
import com.hzqing.modules.system.api.dto.CreateSysServiceRequest;
import com.hzqing.modules.system.api.dto.SysServiceDto;
import com.hzqing.modules.system.api.dto.SysServiceListRequest;
import com.hzqing.modules.system.api.service.SysServiceService;
import com.hzqing.modules.system.provider.converter.SysServiceConverter;
import com.hzqing.modules.system.provider.dal.entity.SysService;
import com.hzqing.modules.system.provider.dal.mapper.SysServiceMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 服务管理接口实现类 1.0版本
 *
 * @author hzqing
 * @date 2021/2/13 上午9:33
 **/
@DubboService(version = IceVersionConstants.SERVER_VERSION_V10)
public class SysServiceServiceImpl extends BaseServiceImpl<SysService> implements SysServiceService  {

    @Autowired
    private SysServiceMapper serviceMapper;

    @Autowired
    private SysServiceConverter serviceConverter;

    @Override
    public CommonResponse create(CreateSysServiceRequest request) {
        SysService sysService = serviceConverter.convert(request);
        serviceMapper.insert(super.create(sysService));
        return success();
    }

    @Override
    public void removeById(IDRequest request) {
        serviceMapper.deleteById(request.getId());
    }

    @Override
    public IcePageResponse<SysServiceDto> list(SysServiceListRequest request) {
        IcePageResponse<SysServiceDto> response = new IcePageResponse<>();
        try {
            PageHelper.startPage(request.getPageNum(), request.getPageSize());
            List<SysService> list = serviceMapper.selectList(new QueryWrapper<>(new SysService()));
            PageInfo<SysService> pageInfo = new PageInfo<>(list);
            response.setData(serviceConverter.convert(pageInfo.getList()));
            response.setPageNum(pageInfo.getPageNum());
            response.setPageNum(pageInfo.getPageSize());
            response.setTotal(pageInfo.getTotal());
        } finally {
            PageHelper.clearPage();
        }
        return response;
    }

    @Override
    public SysServiceDto getById(IDRequest request) {
        return serviceConverter.convert(serviceMapper.selectById(request.getId()));
    }
}
