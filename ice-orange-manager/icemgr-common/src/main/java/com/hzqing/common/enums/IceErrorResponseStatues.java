package com.hzqing.common.enums;

import com.hzqing.common.constants.IceHttpStatusConstants;
import com.hzqing.common.response.IceBaseErrorInfo;

/**
 * @author 衡钊清
 * @Classname IceErrorReponseStatues
 * @Description 错误的响应状态信息
 * @Date 2020/7/23 22:16
 */
public enum IceErrorResponseStatues implements IceBaseErrorInfo {
    INVALID_PARAMETER("InvalidParameter", IceHttpStatusConstants.BAD_REQUEST,"无效的参数，请检查该参数是否正确。"),
    INVALID_PARAMETER_IS_NULL("InvalidParameter.IsNull",IceHttpStatusConstants.BAD_REQUEST,"参数不能为空，请您该参数是否正确。"),
    INVALID_ID_NOT_FOUND("InvalidId.NotFound",IceHttpStatusConstants.BAD_REQUEST,"Id不存在，请您检查Id是否正确。");




    IceErrorResponseStatues(String code, int httpCode, String message) {
        this.code = code;
        this.httpCode = httpCode;
        this.message = message;
    }

    private String code;

    private int httpCode;

    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public int getHttpCode() {
        return httpCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
