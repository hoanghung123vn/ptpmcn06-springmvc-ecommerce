package com.example.demo.controller.admin;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Goal;
import com.example.demo.service.goal.GoalService;
import com.example.demo.service.orders.OrdersService;
import com.example.demo.service.product.ProductService;
import com.example.demo.service.type.TypeService;
import com.example.demo.service.user.UserService;

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
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TypeService typeService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private OrdersService ordersService;
    
    @Autowired
    private GoalService goalService;
    
    @GetMapping("/statistical")
    public String statistical(Model model) {
        model.addAttribute("countMember", userService.countMember());
        model.addAttribute("countEmployee", userService.countEmployee());
        model.addAttribute("countType", typeService.countAll());
        model.addAttribute("countProduct", productService.countAll());
        model.addAttribute("countOrderInDay", ordersService.countOrderInDay());
        model.addAttribute("countOrderInWeek", ordersService.countOrderInWeek());
        model.addAttribute("countOrderInMonth", ordersService.countOrderInMonth());
        model.addAttribute("countOrderInYear", ordersService.countOrderInYear());
        model.addAttribute("sumPriceOrdersInDay", ordersService.sumPriceOrdersInDay());
        model.addAttribute("sumPriceOrdersInWeek", ordersService.sumPriceOrdersInWeek());
        model.addAttribute("sumPriceOrdersInMonth", ordersService.sumPriceOrdersInMonth());
        model.addAttribute("sumPriceOrdersInYear", ordersService.sumPriceOrdersInYear());
        model.addAttribute("top5product", productService.findTop5BestSeller()); 
        model.addAttribute("goal", goalService.getGoalOfMonth());
        Calendar calendar = Calendar.getInstance();
        model.addAttribute("numberOrderOfMonths", ordersService.getNumberOrderOfMonths(calendar.get(Calendar.YEAR)).toString());
        model.addAttribute("sumPriceOfMonths", ordersService.getSumPriceOfMonths(calendar.get(Calendar.YEAR)).toString());
        return "admin/statistical";
    }
      
    @GetMapping("/goal-setting")
    public String goal(Model model) {
        model.addAttribute("goal", goalService.getGoalOfMonth());
        return "admin/goal_setting";
    }
    
    @PostMapping("/goal-setting")
    public String setting_goal(Goal goal, RedirectAttributes redirect) {
        goalService.setting(goal);
        redirect.addFlashAttribute("success", "Thiết lập thành công, xem kết quả bên dưới.");
        return "redirect:/admin/goal-setting";
    }
}
