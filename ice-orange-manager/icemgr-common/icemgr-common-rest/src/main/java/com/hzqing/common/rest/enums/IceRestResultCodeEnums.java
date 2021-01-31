package com.hzqing.common.rest.enums;

/**
 * @author hzqing
 * @date 2019-08-11 15:30
 */
public enum IceRestResultCodeEnums {
    SUCCESS("10000", 200, "成功！"),
    SYS_ERROR("10500", 400, "系统错误！");

    private String code;

    private Integer httpCode;

    private String msg;

    IceRestResultCodeEnums(String code, Integer httpCode, String msg) {
        this.code = code;
        this.httpCode = httpCode;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
