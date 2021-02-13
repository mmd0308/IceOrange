package com.hzqing.common.api.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 服务提供者通用的响应类
 *
 * @author hzqing
 * @date 2021/1/31 16:30
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class CommonResponse<T> extends AbstractResponse {

    private static final long serialVersionUID = 8091884787659239002L;

    /**
     * 请求Id
     */
    private String requestId;

    /**
     * 响应的数据
     */
    private T data;

}
