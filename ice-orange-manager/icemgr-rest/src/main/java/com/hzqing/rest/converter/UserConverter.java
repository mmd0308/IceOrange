package com.hzqing.rest.converter;

import com.hzqing.rest.vo.SysUserVo;
import com.hzqing.system.dal.entity.SysUser;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author 衡钊清
 * @Classname UserConverter
 * @Description 系统用户数据转换器
 * @Date 2020/7/22 23:36
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    SysUser voToEntity(SysUserVo userVo);

    List<SysUserVo> listEntityToListVo(List<SysUser> list);
}
