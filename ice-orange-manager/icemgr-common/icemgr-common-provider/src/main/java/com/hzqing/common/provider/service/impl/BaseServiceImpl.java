package com.hzqing.common.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.provider.dal.entity.BaseEntity;
import com.hzqing.common.provider.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * 基础的服务实现类
 *
 * @author hzqing
 * @date 2021/1/31 16:36
 **/
@Slf4j
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> implements BaseService<T> {

    @Autowired
    @SuppressWarnings("all")
    private M mapper;

    @Override
    public IPage<T> getPage(int num, int size, T t) {
        log.info("num: {},size: {},user: {}", num, size, t);
        return mapper.selectPage(new Page<T>(num, size), new QueryWrapper<>(t));
    }

    @Override
    public int realDelById(String id) {
        log.info("delete by id [{}].", id);
        return mapper.deleteById(id);
    }

    @Override
    public int add(T t) {
        log.info("add [{}].", t);
        t.setCreateTime(LocalDateTime.now());
        return mapper.insert(t);
    }

    @Override
    public T getById(String id) {
        T t = mapper.selectById(id);
        log.info("get by id[{}]. result: {}", id, t);
        return t;
    }

    @Override
    public int modifyById(T t) {
        log.info("update by id. params: {}", t);
        t.setCreateTime(LocalDateTime.now());
        return mapper.updateById(t);
    }
}
