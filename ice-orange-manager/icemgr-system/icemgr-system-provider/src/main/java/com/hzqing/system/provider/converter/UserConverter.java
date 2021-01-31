package com.hzqing.system.provider.converter;

import com.hzqing.system.api.dto.user.UserDto;
import com.hzqing.system.provider.dal.entity.SysUser;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-09 17:04
 */
@Mapper(componentModel = "spring")
public interface UserConverter {


    UserDto userToDto(SysUser sysUser);

    List<UserDto> listToListDto(List<SysUser> records);
}
