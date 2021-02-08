package com.hzqing.modules.system.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzqing.common.api.request.IDRequest;
import com.hzqing.common.api.response.IcePageResponse;
import com.hzqing.common.core.constants.IceVersionConstants;
import com.hzqing.modules.system.api.dto.CreateUserGroupRequest;
import com.hzqing.modules.system.api.dto.UserGroupDto;
import com.hzqing.modules.system.api.dto.UserGroupListRequest;
import com.hzqing.modules.system.api.service.IceUserGroupService;
import com.hzqing.modules.system.provider.converter.UserGroupConverter;
import com.hzqing.modules.system.provider.dal.entity.SysUserGroup;
import com.hzqing.modules.system.provider.dal.mapper.SysUserGroupMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 衡钊清
 * @Classname SysUserServiceImpl
 * @Description 用户管理 业务实现
 * @Date 2020/7/22 20:40
 */
@DubboService(version = IceVersionConstants.SERVER_VERSION_V10)
public class SysUserGroupServiceImpl implements IceUserGroupService {

    @Autowired
    private SysUserGroupMapper userGroupMapper;

    @Autowired
    private UserGroupConverter userGroupConverter;

    @Override
    public void create(CreateUserGroupRequest request) {
        userGroupMapper.insert(userGroupConverter.convert(request));
    }

    @Override
    public IcePageResponse<UserGroupDto> list(UserGroupListRequest request) {
        IcePageResponse<UserGroupDto> response = new IcePageResponse<>();
        try {
            PageHelper.startPage(request.getPageNum(), request.getPageSize());
            List<SysUserGroup> list = userGroupMapper.selectList(new QueryWrapper<>(new SysUserGroup()));
            PageInfo<SysUserGroup> pageInfo = new PageInfo<>(list);
            response.setData(userGroupConverter.convert(pageInfo.getList()));
            response.setPageNum(pageInfo.getPageNum());
            response.setPageNum(pageInfo.getPageSize());
            response.setTotal(pageInfo.getTotal());
        } finally {
            PageHelper.clearPage();
        }
        return response;
    }

    @Override
    public UserGroupDto getById(IDRequest request) {
        return userGroupConverter.convert(userGroupMapper.selectById(request.getId()));
    }

    @Override
    public void removeById(IDRequest request) {
        userGroupMapper.deleteById(request.getId());
    }
}
