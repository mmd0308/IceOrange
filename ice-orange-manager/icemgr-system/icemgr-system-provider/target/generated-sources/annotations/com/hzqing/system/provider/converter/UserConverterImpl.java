package com.hzqing.system.provider.converter;

import com.hzqing.system.api.dto.user.UserDto;
import com.hzqing.system.provider.dal.entity.SysUser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-31T21:41:17+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UserDto userToDto(SysUser sysUser) {
        if ( sysUser == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( sysUser.getId() );
        userDto.setPassword( sysUser.getPassword() );
        userDto.setEmail( sysUser.getEmail() );
        userDto.setCreateTime( sysUser.getCreateTime() );
        userDto.setUpdateTime( sysUser.getUpdateTime() );

        return userDto;
    }

    @Override
    public List<UserDto> listToListDto(List<SysUser> records) {
        if ( records == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( records.size() );
        for ( SysUser sysUser : records ) {
            list.add( userToDto( sysUser ) );
        }

        return list;
    }
}
