package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Role;

/**
 * @author Hung Hoang
 * @version 1.0 Nov 19, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name RoleRepository.java
 * @description TODO
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}