package com.hzqing.modules.system.api.service;

import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.api.response.CommonResponse;
import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.modules.system.api.dto.CreateSysServiceRequest;
import com.hzqing.modules.system.api.dto.SysServiceDto;
import com.hzqing.modules.system.api.dto.SysServiceListRequest;

/**
 * 服务管理 api接口
 *
 * @author hzqing
 * @date 2021/2/13 上午9:39
 **/
public interface SysServiceService {

    CommonResponse create(CreateSysServiceRequest request);

    void removeById(IDRequest request);

    IcePageResponse<SysServiceDto> list(SysServiceListRequest request);

    SysServiceDto getById(IDRequest idRequest);
}
