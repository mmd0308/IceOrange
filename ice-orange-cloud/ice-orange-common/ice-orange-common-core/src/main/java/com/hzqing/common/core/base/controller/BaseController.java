package com.hzqing.common.core.base.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author 衡钊清
 * @classname BaseController
 * @description TODO
 * @date 2021-10-25 下午10:32
 */
public class BaseController<T, S extends BaseService> {

    @Autowired
    @SuppressWarnings("all")
    private S baseService;

    @GetMapping("/page/{pageNum}/{pageSize}")
    public Flux<Page<T>> page(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, T t) {
        Page<T> res = baseService.page(pageNum, pageSize, t);
        return Flux.just(res);
    }
}
