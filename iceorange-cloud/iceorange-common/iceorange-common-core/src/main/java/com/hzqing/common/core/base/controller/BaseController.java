package com.hzqing.common.core.base.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.base.entity.BaseEntity;
import com.hzqing.common.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;

/**
 * @author 衡钊清
 * @classname BaseController
 * @description TODO
 * @date 2021-10-25 下午10:32
 */
public class BaseController<E extends BaseEntity, S extends BaseService> {

    @Autowired
    @SuppressWarnings("all")
    private S service;

    @GetMapping("/page/{pageNum}/{pageSize}")
    public Flux<Page<E>> page(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, E e) {
        Page<E> res = service.page(pageNum, pageSize, e);
        return Flux.just(res);
    }
}
