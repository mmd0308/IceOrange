package com.hzqing.modules.system.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.modules.system.api.dto.CreateUserRequest;
import com.hzqing.modules.system.api.dto.UpdateUserRequest;
import com.hzqing.modules.system.api.dto.UserDto;
import com.hzqing.modules.system.api.dto.UserListRequest;
import com.hzqing.modules.system.api.service.IceUserService;
import com.hzqing.modules.system.provider.converter.UserConverter;
import com.hzqing.modules.system.provider.dal.entity.SysUser;
import com.hzqing.modules.system.provider.dal.mapper.SysUserMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 衡钊清
 * @Classname SysUserServiceImpl
 * @Description 用户管理 业务实现
 * @Date 2020/7/22 20:40
 */
@DubboService
public class SysUserServiceImpl implements IceUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private UserConverter userConverter;


    @Override
    public void create(CreateUserRequest request) {
        SysUser user = userConverter.requestToUser(request);
        userMapper.insert(user);
    }

    @Override
    public UserDto getById(IDRequest request) {
        request.checkParams();
        SysUser sysUser = userMapper.selectById(request.getId());
        return userConverter.userToDto(sysUser);
    }

    @Override
    public IcePageResponse<UserDto> list(UserListRequest request) {
        IcePageResponse<UserDto> response = new IcePageResponse<>();
        try {
            PageHelper.startPage(request.getPageNum(), request.getPageSize());
            List<SysUser> list = userMapper.selectList(new QueryWrapper<>(new SysUser()));
            PageInfo<SysUser> pageInfo = new PageInfo<>(list);
            response.setData(userConverter.convert(pageInfo.getList()));
            response.setPageNum(pageInfo.getPageNum());
            response.setPageNum(pageInfo.getPageSize());
            response.setTotal(pageInfo.getTotal());
        } finally {
            PageHelper.clearPage();
        }
        return response;
    }

    @Override
    public void removeById(IDRequest request) {
        userMapper.deleteById(request.getId());
    }

    @Override
    public void updateById(UpdateUserRequest request) {
        userMapper.updateById(userConverter.convert(request));
    }
}
