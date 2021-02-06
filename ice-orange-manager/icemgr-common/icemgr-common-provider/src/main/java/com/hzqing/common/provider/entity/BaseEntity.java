package com.hzqing.common.provider.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 基础实体类
 *
 * @author hzqing
 * @date 2021/1/31 16:31
 **/
@Setter
@Getter
public class BaseEntity {

    /**
     * 表主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

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
