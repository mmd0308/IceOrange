package com.hzqing.modules.system.api.dto;

import com.hzqing.common.api.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author hzqing
 * @date 2019-08-10 00:35
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CreateUserGroupRequest extends AbstractRequest {

    /**
     * 用户组名称
     */
    @NotNull(message = "用户组名称不能为空。")
    private String name;

    /**
     * 显示的名称
     */
    private String showName;

    private String remark;

    /**
     * 请求参数进行校验
     */
    @Override
    public void checkParams() {
    }
}
