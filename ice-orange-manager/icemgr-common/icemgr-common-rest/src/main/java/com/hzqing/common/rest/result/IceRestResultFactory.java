package com.hzqing.common.rest.result;

import com.hzqing.common.rest.enums.IceRestResultCodeEnums;

/**
 * 创建响应结果对象工厂
 *
 * @author hzqing
 * @date 2019-08-11 15:38
 */
public class IceRestResultFactory<T> {


    public IceRestResult success() {
        return success(null);
    }

    public IceRestResult success(T attributes) {
        return success(IceRestResultCodeEnums.SUCCESS.getMsg(),
                attributes);
    }

    public IceRestResult success(String msg, T attributes) {
        return build(IceRestResultCodeEnums.SUCCESS.getCode(),
                msg,
                attributes);
    }

    public IceRestResult error() {
        return build(IceRestResultCodeEnums.SYS_ERROR.getCode(),
                IceRestResultCodeEnums.SYS_ERROR.getMsg());
    }

    public IceRestResult error(String msg) {
        return build(IceRestResultCodeEnums.SYS_ERROR.getCode(),
                msg);
    }

    public IceRestResult build(String code, String msg) {
        return build(code, msg, null);
    }

    public IceRestResult<T> build(String code, String msg, T attributes) {
        return new IceRestResult(code, msg, attributes);
    }


    /**
     * 获取工程实例
     *
     * @return
     */
    public static IceRestResultFactory getInstance() {
        return INSTANCE;
    }

    private IceRestResultFactory() {
    }

    private static IceRestResultFactory INSTANCE = new IceRestResultFactory();

}
