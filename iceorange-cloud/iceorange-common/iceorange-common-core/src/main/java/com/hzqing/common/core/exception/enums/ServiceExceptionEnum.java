package com.hzqing.common.core.exception.enums;

import com.hzqing.common.core.exception.BaseErrorInfo;

/**
 * @author 衡钊清
 * @classname ServiceExceptionEnum
 * @description ServiceException 错误枚举映射类
 * @date 2021-10-25 下午10:08
 */
public enum ServiceExceptionEnum implements BaseErrorInfo {
    ;


    ServiceExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
