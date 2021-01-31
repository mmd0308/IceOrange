package com.hzqing.rest.controller.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.rest.constants.IceApiPathConstants;
import com.hzqing.common.rest.result.IceRestResult;
import com.hzqing.common.rest.result.IceRestResultFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 衡钊清
 * @classname SysUserController
 * @description 系统用户信息
 * @date 2020/7/22 21:04
 */
@RestController
@RequestMapping(IceApiPathConstants.SYSTEM_BATH_V1 + "/users/groups")
public class SysUsersGroupController {

    @GetMapping("/page/{num}/{size}")
    public IceRestResult<Page<Object>> page(@PathVariable int num,
                                            @PathVariable int size) {

        return IceRestResultFactory.getInstance().error();
    }
}
