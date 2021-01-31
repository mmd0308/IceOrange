package com.hzqing.common.provider.common.request;

import java.io.Serializable;

/**
 * @author 衡钊清
 * @Classname AbstractRequest
 * @Description 抽象请求类
 * @Date 2020/7/22 23:06
 */
public abstract class AbstractRequest implements Serializable {

    private static final long serialVersionUID = 5699898200667187500L;

    private String updateTime;

    /**
     * 创建请求参数检查
     */
    public void checkCreateParams() {

    }

    /**
     * 更新请求参数检查
     */
    public void checkUpdateParams() {

    }


    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
