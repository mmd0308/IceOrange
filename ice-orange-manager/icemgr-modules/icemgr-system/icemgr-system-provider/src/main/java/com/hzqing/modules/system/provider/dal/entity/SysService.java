package com.hzqing.modules.system.provider.dal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.provider.dal.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 服务管理实体类
 *
 * @author hzqing
 * @date 2021/2/13 上午9:28
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_service")
public class SysService extends BaseEntity {

    private String name;

    @TableField("show_name")
    private String showName;

    private String remark;

    private char status;

    private String version;
}
