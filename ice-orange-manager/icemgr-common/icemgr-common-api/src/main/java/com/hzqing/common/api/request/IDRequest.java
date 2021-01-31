package com.hzqing.common.api.request;

import lombok.Data;
import lombok.ToString;

/**
 * id 主键校验
 *
 * @author hzqing
 * @date 2019-08-13 21:11
 */
@Data
@ToString(callSuper = true)
public class IDRequest extends AbstractRequest {

    private static final long serialVersionUID = 4085265036094778483L;
    /**
     * 主键
     */
    private String id;

    public IDRequest() {
    }

    public IDRequest(String id) {
        this.id = id;
    }

    @Override
    public void checkParams() {
        if (null == id || id.equals("") || id == "") {
//            throw new ParamsValidateException(
//                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
//                    "主键ID,不能为空"
//            );
        }
    }
}
