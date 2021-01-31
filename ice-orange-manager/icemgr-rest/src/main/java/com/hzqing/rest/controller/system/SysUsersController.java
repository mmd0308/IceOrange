package com.hzqing.rest.controller.system;

import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.common.rest.constants.IceApiPathConstants;
import com.hzqing.common.rest.constants.IceVersionConstants;
import com.hzqing.system.api.dto.user.UserDto;
import com.hzqing.system.api.dto.user.UserListRequest;
import com.hzqing.system.api.service.SysUsersService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 衡钊清
 * @classname SysUserController
 * @description 系统用户信息
 * @date 2020/7/22 21:04
 */
@RestController
@RequestMapping(IceApiPathConstants.SYSTEM_BATH_V1 + "/users")
public class SysUsersController {

    @Reference(version = IceVersionConstants.VERSION_V1)
    private SysUsersService userService;

    public void save() throws Exception {
        userService.save(null);
    }

    @GetMapping
    public IcePageResponse<UserDto> list( UserListRequest userListRequest) {
        return userService.list(userListRequest);
    }

}
