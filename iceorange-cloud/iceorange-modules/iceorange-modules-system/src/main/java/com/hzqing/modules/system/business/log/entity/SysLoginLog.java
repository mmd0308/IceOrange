package com.hzqing.modules.system.business.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.core.base.entity.BaseEntity;
import lombok.Data;

/**
 * @author 衡钊清
 * @classname SysLoginLog
 * @description 登陆日志实体类
 * @date 2021-10-26 下午10:18
 */
@Data
@TableName("sys_login_log")
public class SysLoginLog extends BaseEntity {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

}
