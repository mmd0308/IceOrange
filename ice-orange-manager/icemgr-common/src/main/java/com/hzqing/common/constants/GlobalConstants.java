package com.hzqing.common.constants;

/**
 * @author 衡钊清
 * @Classname GlobalConstants
 * @Description 全局常量
 * @Date 2020/7/22 21:04
 */
public class GlobalConstants {

    private GlobalConstants() {
        new Exception("私有构造不能实例!");
    }

    /**
     * 服务版本 v1
     */
    public final static String VERSION_V1 = "/v1";

    /**
     * 服务版本 v2
     */
    public final static String VERSION_V2 = "/v2/";

    /**
     * api基础路径
     */
    public final static String API_PATH = "/api";

    /**
     * 系统服务 v1 基础路径
     */
    public final static String SYSTEM_BATH_V1 = API_PATH + "/system" + VERSION_V1;

}
