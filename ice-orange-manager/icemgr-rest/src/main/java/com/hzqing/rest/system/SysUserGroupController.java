package com.hzqing.rest.system;

import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.common.core.constants.IceVersionConstants;
import com.hzqing.modules.system.api.dto.CreateUserGroupRequest;
import com.hzqing.modules.system.api.dto.UserGroupDto;
import com.hzqing.modules.system.api.dto.UserGroupListRequest;
import com.hzqing.modules.system.api.service.IceUserGroupService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 衡钊清
 * @classname SysUserController
 * @description 系统用户信息
 * @date 2020/7/22 21:04
 */
@RestController
@Validated
@RequestMapping(IceVersionConstants.REST_VERSION_V1 + "/users/groups")
public class SysUserGroupController {

    @DubboReference(version = IceVersionConstants.SERVER_VERSION_V10)
    private IceUserGroupService userGroupService;


    @GetMapping
    public IcePageResponse<UserGroupDto> list(UserGroupListRequest request) {
        return userGroupService.list(request);
    }

    @GetMapping("/{id}")
    public UserGroupDto getById(@PathVariable String id) {
        return userGroupService.getById(new IDRequest(null));
    }

    @PostMapping
    public void create(@RequestBody @Valid CreateUserGroupRequest request) {
        userGroupService.create(request);
    }

    @DeleteMapping("/{id}")
    public void removeById(String id) {
        userGroupService.removeById(new IDRequest(id));
    }
}
