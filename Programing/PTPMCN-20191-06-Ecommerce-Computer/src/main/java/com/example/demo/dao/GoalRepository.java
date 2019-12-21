package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Goal;

/**
 * @author Hung Hoang
 * @version 1.0 Dec 21, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name GoalRepository.java
 * @description TODO
 */
public interface GoalRepository extends CrudRepository<Goal, Integer>{
    Goal findByName(String name);
}
