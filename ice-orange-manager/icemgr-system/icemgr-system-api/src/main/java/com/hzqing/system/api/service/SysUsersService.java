package com.hzqing.system.api.service;

import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.system.api.dto.user.AddUserRequest;
import com.hzqing.system.api.dto.user.UpdateUserRequest;
import com.hzqing.system.api.dto.user.UserDto;
import com.hzqing.system.api.dto.user.UserListRequest;

/**
 * @author 衡钊清
 * @Classname ISysUserService
 * @Description 系统用户 业务层
 * @Date 2020/7/22 21:04
 */
public interface SysUsersService {


    /**
     * 创建用户
     *
     * @param request
     * @return›
     */
    void save(AddUserRequest request);


    /**
     * 根据id获取用户的信息
     *
     * @param request
     * @return
     */
    UserDto getById(IDRequest request);


    /**
     * 根据条件获取用户分页列表
     *
     * @param request
     * @return
     */
    IcePageResponse<UserDto> list(UserListRequest request);


    /**
     * 根据id删除用户
     *
     * @param request
     */
    void removeById(IDRequest request);

    /**
     * 根据id，更新用户
     *
     * @param request
     */
    void updateById(UpdateUserRequest request);

}
