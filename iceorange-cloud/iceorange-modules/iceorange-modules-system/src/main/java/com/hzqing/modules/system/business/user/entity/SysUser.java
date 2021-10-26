package com.hzqing.modules.system.business.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.core.base.entity.BaseEntity;
import lombok.Data;

/**
 * @author 衡钊清
 * @Classname SysUser
 * @Description 系统用户表实体类
 * @Date 2020/7/22 23:16
 */
@Data
@TableName(value = "sys_user")
public class SysUser extends BaseEntity {

    /**
     * 用户id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;


    /**
     * 部门ID
     */
    @TableField("dept_id")
    private String deptId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 密码
     */
    private String password;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标志（0:存在 1:删除）
     */
    @TableField("del_flag")
    private String delFlag;
}
