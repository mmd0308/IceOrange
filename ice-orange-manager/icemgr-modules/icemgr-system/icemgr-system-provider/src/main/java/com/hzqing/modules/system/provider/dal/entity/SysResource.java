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
 * @Classname SysResources
 * @Description
 * @Date 2020/7/24 20:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_resource")
public class SysResource extends BaseEntity {
    /**
     * 用户id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父级Id
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 顺序
     */
    private Integer sort;

    /**
     * 请求url地址
     */
    private String url;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 资源图标
     */
    private String icon;

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
