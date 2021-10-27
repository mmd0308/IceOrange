package com.hzqing.common.core.base.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.base.entity.BaseEntity;
import com.hzqing.common.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author 衡钊清
 * @classname BaseController
 * @description TODO
 * @date 2021-10-25 下午10:32
 */
public class BaseController<T extends BaseEntity, S extends BaseService> {

    @Autowired
    @SuppressWarnings("all")
    private S service;

    @PostMapping("/action")
    public Mono<Integer> save(@RequestBody T entity) {
        int save = service.save(entity);
        return Mono.just(save);
    }

    @DeleteMapping("/action/{id}")
    public Mono<Integer> remove(@PathVariable String id) {
        return Mono.just(service.deleteById(id));
    }

    @PutMapping("/action/{id}")
    public Mono<Integer> update(@PathVariable String id, T entity) {
        return Mono.just(service.updateById(entity));
    }

    @GetMapping("/page/{pageNum}/{pageSize}")
    public Flux<Page<T>> page(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, T e) {
        Page<T> res = service.selectPage(pageNum, pageSize, e);
        return Flux.just(res);
    }

    @GetMapping("/{id}")
    public Mono<T> getById(@PathVariable String id) {
        return (Mono<T>) Mono.just(service.selectById(id));
    }

}
