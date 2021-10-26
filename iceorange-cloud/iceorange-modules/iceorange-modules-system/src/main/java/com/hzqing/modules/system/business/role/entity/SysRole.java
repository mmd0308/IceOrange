package com.hzqing.modules.system.business.role.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.core.base.entity.BaseEntity;
import lombok.Data;

@Data
@TableName(value = "sys_role")
public class SysRole extends BaseEntity {

    /**
     * 用户id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色权限字符串
     */
    private String permission;

    /**
     * 顺序
     */
    private Integer sort;

    /**
     * 角色状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

}
