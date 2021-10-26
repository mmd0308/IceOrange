package com.hzqing.common.core.exception.enums;

import com.hzqing.common.core.exception.BaseErrorInfo;

/**
 * @author 衡钊清
 * @classname ServiceExceptionEnum
 * @description 通用错误枚举映射类
 * @date 2021-10-25 下午10:08
 */
public enum CommonExceptionEnum implements BaseErrorInfo {
    // 数据操作错误定义
    SUCCESS("200", "成功!"),
    BODY_NOT_MATCH("400", "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401", "请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503", "服务器正忙，请稍后再试!");


    CommonExceptionEnum(String code, String msg) {
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
