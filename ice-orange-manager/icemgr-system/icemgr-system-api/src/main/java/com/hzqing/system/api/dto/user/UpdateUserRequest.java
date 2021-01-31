package com.hzqing.system.api.dto.user;

import com.hzqing.common.api.request.IDRequest;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * TODO
 *
 * @author hzqing
 * @date 2021/1/31 21:01
 **/
@Data
public class UpdateUserRequest extends IDRequest {

    /**
     * 用户名
     */
    private String username;

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
     * 更新时间
     */
    private LocalDateTime updateTime;

    @Override
    public void checkParams() {
        super.checkParams();
    }
}
