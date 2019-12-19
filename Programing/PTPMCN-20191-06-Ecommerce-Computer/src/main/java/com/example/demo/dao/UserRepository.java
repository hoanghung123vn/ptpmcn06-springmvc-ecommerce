package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.User;

/**
 * @author Hung Hoang
 * @version 1.0 Nov 16, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name UserRepository.java
 * @description TODO
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    
    @Query("select u from User u")
    List<User> findAll();
    
    @Query("from User u left join fetch u.roles where u.email = ?1")
    User findByEmail(String email);
    
    List<User> findByEmailContaining(String email);
}
