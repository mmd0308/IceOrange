package com.hzqing.core.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hzqing.common.provider.dal.entity.BaseEntity;
import com.hzqing.common.provider.service.IBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 衡钊清
 * @Classname IceBaseController
 * @Description 基础Controller类
 * @da 2020/7/23 23:16
 */
@Slf4j
public class BaseController<S extends IBaseService<T>, T extends BaseEntity> {

    @Autowired
    @SuppressWarnings("all")
    private S service;

    @GetMapping("/{id}")
    public T getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/page/{num}/{size}")
    public IPage<T> getPage(@PathVariable int num, @PathVariable int size, T t) {
        return service.getPage(num, size, t);
    }

    @PutMapping("/{id}")
    public void modifyById(@PathVariable String id, @RequestBody T t) {
        service.modifyById(t);
    }

    @PostMapping
    public void add(@RequestBody T t) {
        service.add(t);
    }

    @DeleteMapping("/{id}")
    public void realDelById(@PathVariable String id) {
        service.realDelById(id);
    }

}
