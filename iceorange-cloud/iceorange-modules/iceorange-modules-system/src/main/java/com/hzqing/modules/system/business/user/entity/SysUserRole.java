package com.hzqing.modules.system.business.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 衡钊清
 * @Classname SysUserRole
 * @Description 用户角色
 * @Date 2020/7/24 20:38
 */
@Data
@TableName("sys_user_role")
public class SysUserRole {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String userId;

    private String roleId;
}
