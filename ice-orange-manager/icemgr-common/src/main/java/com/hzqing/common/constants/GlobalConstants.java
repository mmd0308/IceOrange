package com.hzqing.common.provider.common.constants;

/**
 * @author 衡钊清
 * @Classname GlobalConstants
 * @Description   全局常量
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

}
