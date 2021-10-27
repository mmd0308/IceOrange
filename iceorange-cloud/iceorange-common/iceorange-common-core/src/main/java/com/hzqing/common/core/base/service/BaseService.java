package com.hzqing.common.core.base.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author 衡钊清
 * @classname BaseService
 * @description 基础服务接口
 * @date 2021-10-25 下午10:42
 */
public interface BaseService<T extends BaseEntity> {
    int save(T entity);

    int deleteById(Serializable id);

    int deleteBatchIds(Collection<? extends Serializable> idList);

    int updateById(T entity);

    T selectById(Serializable id);

    List<T> selectBatchIds(Collection<? extends Serializable> idList);

    List<T> selectList(T entity);

    Page<T> selectPage(Integer pageNum, Integer pageSize, T entity);
}
