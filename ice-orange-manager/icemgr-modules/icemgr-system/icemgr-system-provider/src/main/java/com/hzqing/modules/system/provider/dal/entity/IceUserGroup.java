package com.hzqing.modules.system.provider.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.provider.entity.BaseEntity;
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
@TableName(value = "ice_user_group")
public class IceUserGroup extends BaseEntity {

    private String name;

    @TableField("show_name")
    private String showName;

    private String remark;
}
