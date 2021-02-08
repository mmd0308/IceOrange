package com.hzqing.modules.system.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * TODO
 *
 * @author hzqing
 * @date 2021/1/31 20:26
 **/
@Data
public class UserGroupDto implements Serializable {

    private String id;

    private String name;

    private String showName;

    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
