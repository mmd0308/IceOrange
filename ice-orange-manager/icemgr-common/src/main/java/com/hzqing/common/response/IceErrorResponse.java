package com.hzqing.common.provider.common.response;

/**
 * @author 衡钊清
 * @Classname IceErrorResponse
 * @Description 异常响应体
 * @Date 2020/7/23 22:35
 */
public class IceErrorResponse {

    /**
     * 错误响应编码
     */
    private String errorCode;

    /**
     * 错误提示信息
     */
    private String errorMessage;

    public IceErrorResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
