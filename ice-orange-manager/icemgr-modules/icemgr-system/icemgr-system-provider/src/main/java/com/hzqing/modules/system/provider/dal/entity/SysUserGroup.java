package com.hzqing.modules.system.provider.dal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.provider.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 衡钊清
 * @Classname SysUsersGroups
 * @Description 用户组实体类
 * @Date 2021/1/31 08:34
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_user_group")
public class SysUserGroup extends BaseEntity {

    private String name;

    @TableField("show_name")
    private String showName;

    private String remark;
}
