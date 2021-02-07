package com.hzqing.modules.system.provider.converter;

import com.hzqing.modules.system.api.dto.CreateUserGroupRequest;
import com.hzqing.modules.system.api.dto.UserGroupDto;
import com.hzqing.modules.system.provider.dal.entity.IceUserGroup;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-09 17:04
 */
@Mapper(componentModel = "spring")
public interface UserGroupConverter {
    IceUserGroup convert(CreateUserGroupRequest request);

    UserGroupDto convert(IceUserGroup selectById);

    List<UserGroupDto> convert(List<IceUserGroup> list);
}
