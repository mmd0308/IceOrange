package com.hzqing.system.api.dto.user;


import com.hzqing.common.api.request.PageRequest;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-10 00:57
 */
@Data
public class UserListRequest extends PageRequest {

    @Override
    public void checkParams() {

    }
}
