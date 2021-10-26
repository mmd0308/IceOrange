package com.hzqing.common.core.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 衡钊清
 * @classname BaseEntity
 * @description TODO
 * @date 2021-10-26 下午10:05
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * 创建者账号
     */
    @TableField("created_by")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /**
     * 更新者账号
     */
    @TableField("updated_by")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField("updated_at")
    private LocalDateTime updatedAt;

}
