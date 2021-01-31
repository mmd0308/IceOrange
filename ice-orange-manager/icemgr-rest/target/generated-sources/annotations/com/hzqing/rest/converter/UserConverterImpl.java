package com.hzqing.rest.converter;

import com.hzqing.rest.vo.SysUserVo;
import com.hzqing.system.dal.entity.SysUser;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-31T07:33:03+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public SysUser voToEntity(SysUserVo userVo) {
        if ( userVo == null ) {
            return null;
        }

        SysUser sysUser = new SysUser();

        if ( userVo.getId() != null ) {
            sysUser.setId( String.valueOf( userVo.getId() ) );
        }
        sysUser.setUserName( userVo.getUserName() );
        sysUser.setPassword( userVo.getPassword() );
        if ( userVo.getUpdateTime() != null ) {
            sysUser.setUpdateTime( LocalDateTime.parse( userVo.getUpdateTime() ) );
        }

        return sysUser;
    }

    @Override
    public List<SysUserVo> listEntityToListVo(List<SysUser> list) {
        if ( list == null ) {
            return null;
        }

        List<SysUserVo> list1 = new ArrayList<SysUserVo>( list.size() );
        for ( SysUser sysUser : list ) {
            list1.add( sysUserToSysUserVo( sysUser ) );
        }

        return list1;
    }

    protected SysUserVo sysUserToSysUserVo(SysUser sysUser) {
        if ( sysUser == null ) {
            return null;
        }

        SysUserVo sysUserVo = new SysUserVo();

        if ( sysUser.getUpdateTime() != null ) {
            sysUserVo.setUpdateTime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( sysUser.getUpdateTime() ) );
        }
        if ( sysUser.getId() != null ) {
            sysUserVo.setId( Long.parseLong( sysUser.getId() ) );
        }
        sysUserVo.setUserName( sysUser.getUserName() );
        sysUserVo.setPassword( sysUser.getPassword() );

        return sysUserVo;
    }
}
