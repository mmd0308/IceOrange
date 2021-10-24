package com.hzqing.modules.system.business.role.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 衡钊清
 * @Classname SysRoleRes
 * @Description 角色资源关系
 * @Date 2020/7/24 20:44
 */
@Data
@TableName("sys_role_res")
public class SysRoleRes {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 资源id
     */
    private String resId;
}
