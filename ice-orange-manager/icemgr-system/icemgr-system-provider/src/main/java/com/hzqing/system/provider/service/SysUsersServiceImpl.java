package com.hzqing.system.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.common.rest.constants.IceVersionConstants;
import com.hzqing.system.api.dto.user.AddUserRequest;
import com.hzqing.system.api.dto.user.UpdateUserRequest;
import com.hzqing.system.api.dto.user.UserDto;
import com.hzqing.system.api.dto.user.UserListRequest;
import com.hzqing.system.api.service.SysUsersService;
import com.hzqing.system.provider.converter.UserConverter;
import com.hzqing.system.provider.dal.entity.SysUser;
import com.hzqing.system.provider.dal.mapper.SysUserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 衡钊清
 * @Classname SysUserServiceImpl
 * @Description 用户管理 业务实现
 * @Date 2020/7/22 20:40
 */
@Service(version = IceVersionConstants.VERSION_V1)
public class SysUsersServiceImpl implements SysUsersService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private UserConverter userConverter;


    @Override
    public void save(AddUserRequest request) {

    }

    @Override
    public UserDto getById(IDRequest request) {
        request.checkParams();
        SysUser sysUser = userMapper.selectById(request.getId());
        return userConverter.userToDto(sysUser);
    }

    @Override
    public IcePageResponse<UserDto> list(UserListRequest request) {
        request.checkParams();
        IPage<SysUser> userIPage = userMapper.selectPage(
                new Page<SysUser>(request.getPageNum(), request.getPageSize()),
                new QueryWrapper<>(new SysUser()));
        IcePageResponse<UserDto> response = new IcePageResponse<>();
        response.setData(userConverter.listToListDto(userIPage.getRecords()));
        response.setTotal(userIPage.getTotal());
        return response;
    }

    @Override
    public void removeById(IDRequest request) {

    }

    @Override
    public void updateById(UpdateUserRequest request) {

    }
}
