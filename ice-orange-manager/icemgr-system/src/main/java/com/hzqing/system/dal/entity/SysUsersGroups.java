package com.hzqing.system.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.provider.dal.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author 衡钊清
 * @Classname SysUsersGroups
 * @Description 用户组实体类
 * @Date 2021/1/31 08:34
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_users_groups")
public class SysUsersGroups extends BaseEntity {

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
    @TableField("show_name")
    private String showName;

    /**
     * 顺序
     */
    private Integer sort = 0;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建者账号
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新者账号
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

}
