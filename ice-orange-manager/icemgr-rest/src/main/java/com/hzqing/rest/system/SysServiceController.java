package com.hzqing.rest.system;

import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.common.core.constants.IceVersionConstants;
import com.hzqing.modules.system.api.dto.*;
import com.hzqing.modules.system.api.service.SysServiceService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 服务管理
 *
 * @author hzqing
 * @date 2021/2/13 上午9:52
 **/
@RestController
@Validated
@RequestMapping(IceVersionConstants.REST_VERSION_V1 + "/services")
public class SysServiceController {

    @DubboReference(version = IceVersionConstants.SERVER_VERSION_V10)
    private SysServiceService serviceService;


    @GetMapping
    public IcePageResponse<SysServiceDto> list(SysServiceListRequest request) {
        return serviceService.list(request);
    }

    @GetMapping("/{id}")
    public SysServiceDto getById(@PathVariable String id) {
        return serviceService.getById(new IDRequest(null));
    }

    @PostMapping
    public void create(@RequestBody @Valid CreateSysServiceRequest request) {
        serviceService.create(request);
    }

    @DeleteMapping("/{id}")
    public void removeById(String id) {
        serviceService.removeById(new IDRequest(id));
    }
}
