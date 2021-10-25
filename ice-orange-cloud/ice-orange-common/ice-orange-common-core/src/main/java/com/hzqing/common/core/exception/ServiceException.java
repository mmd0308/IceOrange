package com.hzqing.common.core.exception;

/**
 * @author 衡钊清
 * @classname ServiceException
 * @description 服务运行时产生的异常，错误码可以直接返回给用户
 * @date 2021-10-25 下午10:38
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
        super();
    }

    public ServiceException(BaseErrorInfo info) {
        super(info.getCode());
        this.code = info.getCode();
        this.msg = info.getMsg();
    }

    public ServiceException(String code, String msg) {
        super(code);
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;


}
