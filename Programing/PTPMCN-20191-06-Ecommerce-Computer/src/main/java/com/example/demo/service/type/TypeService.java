package com.example.demo.service.type;

import com.example.demo.entity.Type;

/**
 * @author Hung Hoang
 * @version 1.0 Dec 19, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name TypeService.java
 * @description TODO
 */
public interface TypeService{
    long countAll();
    Iterable<Type> findAll();
}
