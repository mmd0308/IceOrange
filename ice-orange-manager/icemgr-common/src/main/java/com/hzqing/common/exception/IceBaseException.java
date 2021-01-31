package com.hzqing.common.provider.common.exception;

import com.hzqing.common.provider.common.response.IceBaseErrorInfo;

/**
 * @author 衡钊清
 * @Classname BaseException
 * @Description 基础异常类
 * @Date 2020/7/22 21:52
 */
public class IceBaseException extends RuntimeException {

    private static final long serialVersionUID = 4115063828264300633L;

    /**
     * 异常状态码
     */
    private String code;

    /**
     * http状态码
     */
    private int httpCode;

    /**
     * 错误提示信息
     */
    private String message;

    public IceBaseException(IceBaseErrorInfo info) {
        this(info.getCode(), info.getHttpCode(), info.getMessage());
    }

    /**
     * 允许修改默认的提示信息
     *
     * @param info 错误状态
     * @param message 新的提示信息
     */
    public IceBaseException(IceBaseErrorInfo info, String message) {
        this(info.getCode(), info.getHttpCode(), message);
    }

    public IceBaseException(String code, int httpCode, String message) {
        super(message);
        this.code = code;
        this.httpCode = httpCode;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public int getHttpCode() {
        return httpCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
