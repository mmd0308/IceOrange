package com.hzqing.modules.system.provider.converter;

import com.hzqing.modules.system.api.dto.CreateSysServiceRequest;
import com.hzqing.modules.system.api.dto.SysServiceDto;
import com.hzqing.modules.system.provider.dal.entity.SysService;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 实体和dto转换类
 *
 * @author hzqing
 * @date 2021/2/13 上午9:41
 **/
@Mapper(componentModel = "spring")
public interface SysServiceConverter {

    List<SysServiceDto> convert(List<SysService> list);

    SysService convert(CreateSysServiceRequest request);

    SysServiceDto convert(SysService selectById);
}
