package com.hzqing.modules.system.api.service;


import com.hzqing.common.api.request.IDRequest;
import com.hzqing.modules.system.api.dto.CreateUserGroupRequest;

/**
 * @author 衡钊清
 * @Classname ISysUserService
 * @Description 系统用户 业务层
 * @Date 2020/7/22 21:04
 */
public interface IceUserGroupService {

    void create(CreateUserGroupRequest request);

    void removeById(IDRequest request);

}
