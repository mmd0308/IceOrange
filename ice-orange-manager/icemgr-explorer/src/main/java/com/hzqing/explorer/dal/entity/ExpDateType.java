package com.hzqing.common.provider.explorer.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 衡钊清
 * @Classname ExpDateType
 * @Description 数据类型
 * @Date 2020/7/24 20:52
 */
@Data
@TableName("exp_date_type")
public class ExpDateType {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 数据类型名称
     */
    private String name;

    /**
     * 资源类别
     */
    private String category;

    /**
     * 该资源类型
     */
    @TableField("date_type")
    private String dateType;

    /**
     * 描述
     */
    private String description;

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
