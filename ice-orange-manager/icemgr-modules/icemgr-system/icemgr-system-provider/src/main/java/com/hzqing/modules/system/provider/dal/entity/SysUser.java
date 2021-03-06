package com.hzqing.modules.system.provider.dal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.provider.dal.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 衡钊清
 * @Classname SysUser
 * @Description 系统用户表实体类
 * @Date 2020/7/22 23:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_user")
public class SysUser extends BaseEntity {

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;


}
