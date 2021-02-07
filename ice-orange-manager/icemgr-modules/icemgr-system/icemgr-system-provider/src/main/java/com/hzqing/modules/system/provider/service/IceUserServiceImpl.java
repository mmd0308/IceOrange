package com.hzqing.modules.system.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.modules.system.api.dto.CreateUserRequest;
import com.hzqing.modules.system.api.dto.UpdateUserRequest;
import com.hzqing.modules.system.api.dto.UserDto;
import com.hzqing.modules.system.api.dto.UserListRequest;
import com.hzqing.modules.system.api.service.IceUserService;
import com.hzqing.modules.system.provider.converter.UserConverter;
import com.hzqing.modules.system.provider.dal.entity.IceUser;
import com.hzqing.modules.system.provider.dal.mapper.IceUserMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 衡钊清
 * @Classname SysUserServiceImpl
 * @Description 用户管理 业务实现
 * @Date 2020/7/22 20:40
 */
@DubboService
public class IceUserServiceImpl implements IceUserService {

    @Autowired
    private IceUserMapper userMapper;

    @Autowired
    private UserConverter userConverter;


    @Override
    public void create(CreateUserRequest request) {
        IceUser user = userConverter.requestToUser(request);
        userMapper.insert(user);
    }

    @Override
    public UserDto getById(IDRequest request) {
        request.checkParams();
        IceUser sysUser = userMapper.selectById(request.getId());
        return userConverter.userToDto(sysUser);
    }

    @Override
    public IcePageResponse<UserDto> list(UserListRequest request) {
        request.checkParams();
        IPage<IceUser> userIPage = userMapper.selectPage(
                new Page<IceUser>(request.getPageNum(), request.getPageSize()),
                new QueryWrapper<>(new IceUser()));
        IcePageResponse<UserDto> response = new IcePageResponse<>();
        response.setData(userConverter.listToListDto(userIPage.getRecords()));
        response.setTotal(userIPage.getTotal());
        response.setPageNum(userIPage.getCurrent());
        response.setPageSize(userIPage.getSize());
        return response;
    }

    @Override
    public void removeById(IDRequest request) {
        userMapper.deleteById(request.getId());
    }

    @Override
    public void updateById(UpdateUserRequest request) {

    }
}
