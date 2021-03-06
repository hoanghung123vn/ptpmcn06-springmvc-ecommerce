package com.example.demo.service.user;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;

/**
 * @author Hung Hoang
 * @version 1.0 Nov 20, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name UserService.java
 * @description TODO
 */
public interface UserService {
    List<User> findAll();
    
    Optional<User> findById(Integer id);
    
    long countAll();
    
    void deleteById(Integer id);
    
    boolean register(String email, String password);
};
