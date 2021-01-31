package com.hzqing.common.api.response;

import com.hzqing.common.api.enums.ReturnCodeEnums;
import lombok.Data;

import java.io.Serializable;

/**
 * 内部服务请求响应抽象类
 *
 * @author hzqing
 * @date 2021/1/31 16:26
 **/
@Data
public abstract class AbstractResponse implements Serializable {

    private static final long serialVersionUID = -6847272246821135847L;
    /**
     * 请求响应码 默认是成功
     */
    private String code = ReturnCodeEnums.SUCCESS.getCode();

    /**
     * 返回信息  默认是成功提示
     */
    private String msg = ReturnCodeEnums.SUCCESS.getMsg();


}
