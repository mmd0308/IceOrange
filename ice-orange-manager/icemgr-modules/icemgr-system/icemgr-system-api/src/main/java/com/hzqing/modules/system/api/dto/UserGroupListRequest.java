package com.hzqing.modules.system.api.dto;


import com.hzqing.common.api.request.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hzqing
 * @date 2019-08-10 00:57
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserGroupListRequest extends PageRequest {

    @Override
    public void checkParams() {

    }
}
