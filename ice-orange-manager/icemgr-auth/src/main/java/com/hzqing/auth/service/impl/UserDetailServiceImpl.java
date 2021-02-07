package com.hzqing.auth.service.impl;

import com.hzqing.auth.dto.UserDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 衡钊清
 * @classname UserDetailServiceImpl
 * @description TODO
 * @date 2021-02-06 上午9:17
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!username.equals("hzqing")) {
            return null;
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ice:user:list");
        grantedAuthorities.add(authority);
        grantedAuthorities.add(new SimpleGrantedAuthority("ice:user:create"));
        return new UserDetailsDto("hzqing", passwordEncoder.encode("hzqing"), grantedAuthorities);
    }
}
