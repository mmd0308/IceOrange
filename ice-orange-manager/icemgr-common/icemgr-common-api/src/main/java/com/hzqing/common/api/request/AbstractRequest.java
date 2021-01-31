package com.hzqing.common.api.request;

import java.io.Serializable;

/**
 * 请求内部服务的抽象类
 *
 * @author hzqing
 * @date 2021/1/31 20:25
 **/
public abstract class AbstractRequest implements Serializable {

    private static final long serialVersionUID = 8380707862564223666L;

    /**
     * 请求参数检查
     */
    public abstract void checkParams();

}
