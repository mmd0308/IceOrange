package com.hzqing.common.api.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 服务提供者通用的响应类
 *
 * @author hzqing
 * @date 2021/1/31 16:30
 **/
@Data
@ToString(callSuper = true)
public class IcePageResponse<T> implements Serializable {

    private static final long serialVersionUID = 8091884787659239002L;

    /**
     * 响应的数据
     */
    private List<T> data;

    private int page;

    private int size;

    private long total;

}
