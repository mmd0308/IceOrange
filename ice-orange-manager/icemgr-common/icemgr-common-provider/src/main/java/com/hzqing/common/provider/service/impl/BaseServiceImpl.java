package com.hzqing.common.provider.service.impl;

import com.hzqing.common.provider.dal.entity.BaseEntity;

import java.time.LocalDateTime;

/**
 * 基础服务类
 *
 * @author hzqing
 * @date 2021/2/13 上午10:32
 **/
public class BaseServiceImpl<T extends BaseEntity> {

    public T create(T entity) {
        entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());
        //todo
        entity.setCreateBy("admin");
        entity.setUpdateBy("admin");
        return entity;
    }

    public T update(T entity) {
        entity.setUpdateTime(LocalDateTime.now());
        //todo
        entity.setUpdateBy("admin");
        return entity;
    }
}
