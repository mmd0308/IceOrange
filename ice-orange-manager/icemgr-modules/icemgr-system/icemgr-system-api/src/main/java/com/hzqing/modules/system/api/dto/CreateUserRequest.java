package com.hzqing.modules.system.api.dto;

import com.hzqing.common.api.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hzqing
 * @date 2019-08-10 00:35
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CreateUserRequest extends AbstractRequest {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 注册邮箱dd
     */
    private String email;

    /**
     * 0 男 1 女
     */
    private String sex;

    /**
     * 请求参数进行校验
     */
    @Override
    public void checkParams() {

    }
}
