package com.example.demo.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * @author Hung Hoang
 * @version 1.0 Nov 22, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name UserController.java
 * @description TODO
 */


@Controller
@RequestMapping(path = "/admin")
public class AdminCustomerController {
    @Autowired
    private UserService userService;
    
    //@Autowired
    //private ProductService productService;
    
    @GetMapping("/customers")
    public String index(Model model) {
        model.addAttribute("customers", userService.findAll());
        return "admin/customer_list";
    }
    
    @GetMapping("/customers/{id}/orders")
    public String singleUser(@PathVariable("id") Integer id, Model model) {
        Optional<User> customer = userService.findById(id);
        model.addAttribute("customer", customer);
        //model.addAttribute("orders", orderService.FindByUser(customer));
        return "admin/single_custom";
    }
    
    @GetMapping("addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new User());
        return "admin/add_employee";
    }
}
