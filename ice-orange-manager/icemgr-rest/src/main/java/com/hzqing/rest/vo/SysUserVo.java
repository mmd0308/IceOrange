package com.hzqing.rest.vo;

import com.hzqing.common.request.AbstractRequest;
import org.springframework.util.StringUtils;

/**
 * @author 衡钊清
 * @Classname SysUserVo
 * @Description 系统用户表现层
 * @Date 2020/7/22 22:55
 */
public class SysUserVo extends AbstractRequest {

    private static final long serialVersionUID = -606977558429081790L;

    private Long id;

    private String userName;

    private String password;

    @Override
    public void checkUpdateParams() {
        if (!StringUtils.isEmpty(password)){
            // 更新用户信息的时候，不能修改密码

        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
