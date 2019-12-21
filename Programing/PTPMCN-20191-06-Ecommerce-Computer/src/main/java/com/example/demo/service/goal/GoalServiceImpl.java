package com.example.demo.service.goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GoalRepository;
import com.example.demo.entity.Goal;

/**
 * @author Hung Hoang
 * @version 1.0 Dec 21, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name GoalServiceImpl.java
 * @description TODO
 */
@Service
public class GoalServiceImpl implements GoalService {
    
    @Autowired
    private GoalRepository goalRepository;

    @Override
    public void setting(Goal goal) {
        Goal oldGoal = goalRepository.findByName("GOAL_OF_MONTH");
        oldGoal.setNumberOrder(goal.getNumberOrder());
        oldGoal.setRevenue(goal.getRevenue());
        goalRepository.save(oldGoal);
    }

    @Override
    public Goal getGoalOfMonth() {
        return goalRepository.findByName("GOAL_OF_MONTH");
    }

}
