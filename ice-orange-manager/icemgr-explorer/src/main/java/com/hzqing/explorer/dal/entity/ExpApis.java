package com.hzqing.explorer.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.provider.dal.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 衡钊清
 * @classname ExpApis
 * @description TODO
 * @date 2020-08-02 09:18
 */
@Setter
@Getter
@TableName("exp_apis")
public class ExpApis extends BaseEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;


    /**
     * 请求 URL
     */
    @TableField("req_url")
    private String reqUrl;

    /**
     *  请求方式
     */
    @TableField("req_method")
    private String reqMethod;


    /**
     * 描述
     */
    private String description;

    /**
     * 备注
     */
    private String remark;

}
