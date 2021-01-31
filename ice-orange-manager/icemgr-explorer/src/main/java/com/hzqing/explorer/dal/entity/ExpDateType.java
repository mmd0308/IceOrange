package com.hzqing.explorer.dal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.provider.dal.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * @author 衡钊清
 * @Classname ExpDateType
 * @Description 数据类型
 * @Date 2020/7/24 20:52
 */
@Data
@ToString(callSuper = true)
@TableName("exp_date_type")
public class ExpDateType extends BaseEntity {

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
}


