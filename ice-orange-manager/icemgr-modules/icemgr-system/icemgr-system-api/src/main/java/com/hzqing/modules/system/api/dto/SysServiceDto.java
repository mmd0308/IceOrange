package com.hzqing.modules.system.api.dto;

import lombok.Data;

import java.io.Serializable;


/**
 * 服务管理 最全dto类
 *
 * @author hzqing
 * @date 2021/2/13 上午9:37
 **/
@Data
public class SysServiceDto implements Serializable {


    private String id;


    private String name;


    private String showName;


    private String remark;


    private char status;

    private String version;

}
