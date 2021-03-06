package com.hzqing.common.api.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 内部服务请求响应抽象类
 *
 * @author hzqing
 * @date 2021/2/13 上午10:05
 **/
@Data
public abstract class AbstractResponse implements Serializable {

    private static final long serialVersionUID = -6847272246821135847L;

    /**
     * 请求响应码 默认是成功
     */
    private String code;

    /**
     * 返回信息  默认是成功提示
     */
    private String msg;



}
