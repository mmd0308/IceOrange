package com.hzqing.common.rest.result;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 结果响应
 * @author hzq
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IceRestResult<T> implements Serializable {
    private static final long serialVersionUID = -450599376115985279L;
    /**
     * 请求响应码
     */
    private String code;

    /**
     * 响应吗对应的提示信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private IceRestResultData<T> data;


    public IceRestResult(String code, String msg, T attributes) {
        this.code = code;
        this.msg = msg;
        this.data = createBaseResultData(attributes);
    }

    public IceRestResultData<T> createBaseResultData(T attributes){
        IceRestResultData<T> data = new IceRestResultData<>();
        data.setAttributes(attributes);
        return data;
    }

}
