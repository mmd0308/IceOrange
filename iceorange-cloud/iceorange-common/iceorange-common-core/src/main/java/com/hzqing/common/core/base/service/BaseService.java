package com.hzqing.common.core.base.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.base.entity.BaseEntity;

/**
 * @author 衡钊清
 * @classname BaseService
 * @description 基础服务接口
 * @date 2021-10-25 下午10:42
 */
public interface BaseService<E extends BaseEntity> {
    Page<E> page(Integer pageNum, Integer pageSize, E e);
}
