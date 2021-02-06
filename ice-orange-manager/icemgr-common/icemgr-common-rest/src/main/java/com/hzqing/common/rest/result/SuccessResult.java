package com.hzqing.common.rest.result;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 结果响应
 *
 * @author hzq
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResult<T> extends BaseResult {

    private static final long serialVersionUID = -450599376115985279L;

    /**
     * 请求数据
     */
    private T data;

}
