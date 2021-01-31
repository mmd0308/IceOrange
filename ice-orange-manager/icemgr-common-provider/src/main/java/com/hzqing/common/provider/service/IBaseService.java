package com.hzqing.common.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hzqing.common.provider.dal.entity.BaseEntity;

/**
 * @author 衡钊清
 * @Classname IBaseService
 * @Description 基础服务层接口
 * @Date 2020/7/24 21:23
 */
public interface IBaseService<T extends BaseEntity> {

    /**
     * 分页查询用户数据
     *
     * @param num  当前页
     * @param size 显示数量
     * @param t    检索条件
     * @return
     */
    IPage<T> getPage(int num, int size, T t);

    /**
     * 根据id删除
     *
     * @param id 删除的id
     * @return 返回影响的行数
     */
    int realDelById(String id);

    /**
     * 新增数据
     *
     * @param t
     * @return 返回影响的行数
     */
    int add(T t);

    /**
     * 根据id获取数据
     *
     * @param id
     * @return 返回影响的行数
     */
    T getById(String id);

    /**
     * 根据id修改
     *
     * @param t 需要修改的对象
     * @return 返回影响的行数
     */
    int modifyById(T t);
}
