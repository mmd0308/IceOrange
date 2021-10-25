package com.hzqing.common.core.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author 衡钊清
 * @classname BaseServiceImpl
 * @description TODO
 * @date 2021-10-25 下午10:42
 */
public class BaseServiceImpl<T,D, M extends BaseMapper<D>> implements BaseService<T> {

    @SuppressWarnings("all")
    @Autowired
    private M mapper;

    @Override
    public Page<T> page(Integer pageNum, Integer pageSize, T t) {
        return (Page<T>) mapper.selectPage(new Page<D>(pageNum, pageSize), new QueryWrapper<>(null));
    }
}
