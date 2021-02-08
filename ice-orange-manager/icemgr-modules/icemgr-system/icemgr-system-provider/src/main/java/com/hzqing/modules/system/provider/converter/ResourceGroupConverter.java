package com.hzqing.modules.system.provider.converter;

import com.hzqing.modules.system.api.dto.CreateUserRequest;
import com.hzqing.modules.system.api.dto.UserDto;
import com.hzqing.modules.system.provider.dal.entity.SysUser;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-09 17:04
 */
@Mapper(componentModel = "spring")
public interface ResourceGroupConverter {


    UserDto userToDto(SysUser sysUser);

    List<UserDto> listToListDto(List<SysUser> records);

    SysUser requestToUser(CreateUserRequest request);
}
