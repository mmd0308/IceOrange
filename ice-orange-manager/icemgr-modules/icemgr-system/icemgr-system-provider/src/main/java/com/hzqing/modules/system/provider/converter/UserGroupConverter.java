package com.hzqing.modules.system.provider.converter;

import com.hzqing.modules.system.api.dto.CreateUserGroupRequest;
import com.hzqing.modules.system.api.dto.UserGroupDto;
import com.hzqing.modules.system.provider.dal.entity.SysUserGroup;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-09 17:04
 */
@Mapper(componentModel = "spring")
public interface UserGroupConverter {
    SysUserGroup convert(CreateUserGroupRequest request);

    UserGroupDto convert(SysUserGroup selectById);

    List<UserGroupDto> convert(List<SysUserGroup> list);
}
