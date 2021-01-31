package com.hzqing.common.response;

/**
 * @author 衡钊清
 * @Classname BaseErrorInfo
 * @Description 基础异常信息响应类
 * @Date 2020/7/23 22:13
 */
public interface IceBaseErrorInfo {

    /**
     * Description 获取响应编码
     *
     * @Date 2020/7/23 22:14
     * @return
     **/
    String getCode();

    /**
     * 获取http状态码
     *
     * @Date 2020/7/23 22:30
     * @return
     **/
    int getHttpCode();

    /**
     * 请求响应信息
     *
     * @Date 2020/7/23 22:30
     * @return
     **/
    String getMessage();
}
