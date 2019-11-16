package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.config.UserRole;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

/**
 * @author Hung Hoang
 * @version 1.0 Nov 16, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name UserDetailServiceImpl.java
 * @description TODO
 */
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository UserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = UserRepository.findByEmail(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found!!!");

        Set<GrantedAuthority> grandAuthorities = new HashSet<>();
        UserRole role = user.getRole();
        grandAuthorities.add(new SimpleGrantedAuthority(String.valueOf(role)));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                grandAuthorities);
    }

}
