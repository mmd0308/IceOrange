package com.hzqing.modules.system.api.service;


import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.modules.system.api.dto.*;

/**
 * @author 衡钊清
 * @Classname ISysUserService
 * @Description 系统用户 业务层
 * @Date 2020/7/22 21:04
 */
public interface IceUserGroupService {

    void create(CreateUserGroupRequest request);

    UserGroupDto getById(IDRequest request);

    IcePageResponse<UserGroupDto> list(UserGroupListRequest request);

    void removeById(IDRequest request);

}
