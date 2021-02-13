package com.hzqing.common.api.enums;

/**
 * 服务接口响应结果 Code
 *
 * @author hzqing
 * @date 2021/2/13 上午10:11
 **/
public enum ResponseCodeEnum {
    /*
    响应成功
     */
    SUCCESS("SUCCESS", "成功！"),
    SERVICE_ERROR("SERVICE_ERROR", "服务繁忙！"),
    INVALID_PARAMETER("INVALID_PARAMETER", "请求参数缺失！");


    private String code;

    private String msg;

    ResponseCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
