package com.hzqing.common.rest.exception.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础异常类
 *
 * @author hzqing
 * @date 2019-08-10 18:47
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {

    /**
     * 异常状态码
     */
    private String code;

    /**
     * 错误提示信息
     */
    private String message;

    public BaseException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

}
