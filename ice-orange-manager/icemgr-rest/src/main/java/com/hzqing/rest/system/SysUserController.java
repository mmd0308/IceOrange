package com.hzqing.rest.system;

import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.common.core.constants.IceVersionConstants;
import com.hzqing.modules.system.api.dto.CreateUserRequest;
import com.hzqing.modules.system.api.dto.UpdateUserRequest;
import com.hzqing.modules.system.api.dto.SysUserDto;
import com.hzqing.modules.system.api.dto.UserListRequest;
import com.hzqing.modules.system.api.service.IceUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author 衡钊清
 * @classname SysUserController
 * @description 系统用户信息
 * @date 2020/7/22 21:04
 */
@RestController
@Validated
@RequestMapping(IceVersionConstants.REST_VERSION_V1 + "/users")
public class SysUserController {

    @DubboReference(version = IceVersionConstants.SERVER_VERSION_V10)
    private IceUserService userService;

    @PreAuthorize(value = "hasAuthority('ice:user:list')")
    @GetMapping
    public IcePageResponse<SysUserDto> list(UserListRequest userListRequest) {
        return userService.list(userListRequest);
    }

    @PreAuthorize(value = "hasAuthority('ice:user:get')")
    @GetMapping("/{id}")
    public SysUserDto getById(@PathVariable String id) {
        return userService.getById(new IDRequest(id));
    }

    @PreAuthorize(value = "hasAuthority('ice:user:create')")
    @PostMapping
    public void create(@RequestBody CreateUserRequest request) {
        userService.create(request);
    }

    @PutMapping
    public void updateById(UpdateUserRequest request) {
        userService.updateById(request);
    }

    @DeleteMapping("/{id}")
    public void removeById(String id) {
        userService.removeById(new IDRequest(id));
    }

}
