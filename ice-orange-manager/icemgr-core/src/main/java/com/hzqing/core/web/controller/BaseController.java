package com.hzqing.core.web.controller;

import com.hzqing.common.provider.common.enums.IceErrorResponseStatues;
import com.hzqing.common.provider.common.exception.IceBaseException;

/**
 * @author 衡钊清
 * @Classname IceBaseController
 * @Description 基础Controller类
 * @Date 2020/7/23 23:16
 */
public class IceBaseController {

    public void isSuccess(int rows){
        if (0 == rows){
            throw new IceBaseException(IceErrorResponseStatues.INVALID_ID_NOT_FOUND);
        }
    }
}
