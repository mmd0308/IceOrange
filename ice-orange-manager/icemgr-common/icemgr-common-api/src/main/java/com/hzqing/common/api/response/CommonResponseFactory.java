package com.hzqing.common.api.response;

import lombok.Data;
import lombok.ToString;


@Data
@ToString(callSuper = true)
public class CommonResponseFactory {

    public  CommonResponse<?>  success() {
        CommonResponse<T> tCommonResponse = new CommonResponse<T>();
        return tCommonResponse;
    }

}
