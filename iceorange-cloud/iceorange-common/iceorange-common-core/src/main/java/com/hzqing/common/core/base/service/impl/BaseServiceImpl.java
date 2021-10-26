package com.hzqing.common.core.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.base.entity.BaseEntity;
import com.hzqing.common.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author 衡钊清
 * @classname BaseServiceImpl
 * @description TODO
 * @date 2021-10-25 下午10:42
 */
public class BaseServiceImpl<E extends BaseEntity, M extends BaseMapper<E>> implements BaseService<E> {

    @SuppressWarnings("all")
    @Autowired
    private M mapper;

    @Override
    public Page<E> page(Integer pageNum, Integer pageSize, E e) {
        return mapper.selectPage(new Page<E>(pageNum, pageSize), new QueryWrapper<>(null));
    }
}
