package com.hzqing.common.core.base.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author 衡钊清
 * @classname BaseService
 * @description TODO
 * @date 2021-10-25 下午10:42
 */
public interface BaseService<T> {
    Page<T> page(Integer pageNum, Integer pageSize, T t);
}
