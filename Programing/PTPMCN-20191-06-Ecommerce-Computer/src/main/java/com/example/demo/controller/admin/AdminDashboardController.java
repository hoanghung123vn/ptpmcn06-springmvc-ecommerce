package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Hung Hoang
 * @version 1.0 Dec 19, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name AdminDashboardController.java
 * @description TODO
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminDashboardController {
    @GetMapping("/statistical")
    public String statistical(Model model) {
        return "admin/statistical";
    }
      
    @GetMapping("/goal-setting")
    public String goal() {
        return "admin/goal_setting";
    }
}
