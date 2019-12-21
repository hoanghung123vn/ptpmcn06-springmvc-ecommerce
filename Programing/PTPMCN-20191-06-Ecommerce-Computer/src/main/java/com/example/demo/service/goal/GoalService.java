package com.example.demo.service.goal;

import com.example.demo.entity.Goal;

/**
 * @author Hung Hoang
 * @version 1.0 Dec 21, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name GoalService.java
 * @description TODO
 */
public interface GoalService {
    void setting(Goal goal);
    
    Goal getGoalOfMonth();
}
