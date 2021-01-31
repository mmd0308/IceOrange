package com.hzqing.common.rest.constants;

/**
 * @author 衡钊清
 * @Classname GlobalConstants
 * @Description 全局常量
 * @Date 2020/7/22 21:04
 */
public class IceApiPathConstants {

    private IceApiPathConstants() {
    }


    /**
     * api基础路径
     */
    public final static String API_PATH = "/api";

    /**
     * 系统服务 v1 基础路径
     */
    public final static String SYSTEM_BATH_V1 = API_PATH + "/system/" + IceVersionConstants.VERSION_V1;

}
