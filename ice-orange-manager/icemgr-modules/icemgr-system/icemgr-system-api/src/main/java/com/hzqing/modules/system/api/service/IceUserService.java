package com.hzqing.modules.system.api.service;

import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.modules.system.api.dto.CreateUserRequest;
import com.hzqing.modules.system.api.dto.UpdateUserRequest;
import com.hzqing.modules.system.api.dto.UserDto;
import com.hzqing.modules.system.api.dto.UserListRequest;

/**
 * @author 衡钊清
 * @Classname ISysUserService
 * @Description 系统用户 业务层
 * @Date 2020/7/22 21:04
 */
public interface IceUserService {

    void create(CreateUserRequest request);

    UserDto getById(IDRequest request);

    IcePageResponse<UserDto> list(UserListRequest request);

    void removeById(IDRequest request);

    void updateById(UpdateUserRequest request);
}
