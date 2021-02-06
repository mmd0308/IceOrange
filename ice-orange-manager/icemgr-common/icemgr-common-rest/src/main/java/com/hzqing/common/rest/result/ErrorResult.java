package com.hzqing.common.rest.result;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 结果响应
 *
 * @author hzq
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResult extends BaseResult {

    private static final long serialVersionUID = -450599376115985279L;
    /**
     * 请求响应码
     */
    private String code;

    /**
     * 响应吗对应的提示信息
     */
    private String message;

    public ErrorResult() {
    }

    public ErrorResult(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
