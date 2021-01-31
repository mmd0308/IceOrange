package com.hzqing.common.api.request;

import lombok.Data;

/**
 *  分页请求
 * @author hzqing
 * @date 2019-08-11 22:48
 */
@Data
public class PageRequest extends AbstractRequest {
    /**
     * 当前页码
     */
    private int pageNum;

    /**
     * 每页显示数量
     */
    private int pageSize = 10;

    public PageRequest() {
    }

    public PageRequest(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    @Override
    public void checkParams() {
        if (pageNum == 0){
//            throw new ParamsValidateException(
//                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
//                    "分页请求，当前也不能为0");
        }
    }
}
