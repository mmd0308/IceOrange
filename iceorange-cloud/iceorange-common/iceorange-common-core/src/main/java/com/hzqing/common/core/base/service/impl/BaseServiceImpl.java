package com.hzqing.common.core.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.base.entity.BaseEntity;
import com.hzqing.common.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 * @author 衡钊清
 * @classname BaseServiceImpl
 * @description TODO
 * @date 2021-10-25 下午10:42
 */
public class BaseServiceImpl<T extends BaseEntity, M extends BaseMapper<T>> implements BaseService<T> {

    @SuppressWarnings("all")
    @Autowired
    private M mapper;

    @Override
    public int save(T entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<? extends Serializable> idList) {
        return 0;
    }

    @Override
    public int updateById(T entity) {
        return 0;
    }

    @Override
    public T selectById(Serializable id) {
        return mapper.selectById(id);
    }

    @Override
    public List<T> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<T> selectList(T entity) {
        return null;
    }

    @Override
    public Page<T> selectPage(Integer pageNum, Integer pageSize, T entity) {
        return mapper.selectPage(new Page<T>(pageNum, pageSize), new QueryWrapper<>(null));
    }
}
