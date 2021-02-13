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
public class CreateSysServiceRequest extends AbstractRequest {

    /**
     * 名称
     */
    @NotNull(message = "服务名称不能为空。")
    private String name;

    /**
     * 显示的名称
     */
    @NotNull(message = "服务显示名称不能为空。")
    private String showName;

    private String remark;

    @Override
    public void checkParams() {

    }
}
