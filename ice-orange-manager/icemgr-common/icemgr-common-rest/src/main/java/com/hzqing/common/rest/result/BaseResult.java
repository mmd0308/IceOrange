package com.hzqing.common.rest.result;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 结果响应
 *
 * @author hzq
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResult implements Serializable {
    private static final long serialVersionUID = -450599376115985279L;
    /**
     * 请求Id
     */
    private String requestId;

}
