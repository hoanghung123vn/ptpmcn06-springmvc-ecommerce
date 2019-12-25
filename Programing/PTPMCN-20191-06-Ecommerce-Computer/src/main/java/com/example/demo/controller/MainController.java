package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.service.product.ProductService;
import com.example.demo.service.user.UserService;

/**
 * @author Hung Hoang
 * @version 1.0 Nov 16, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name MainController.java
 * @description TODO
 */
@Controller
@RequestMapping(path = "/")
public class MainController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;
    
    @GetMapping(value = {"/", ""})
    public String user(Model model) {
    	model.addAttribute("products", productService.findAll());
        return "user/index";
    }
    
    @RequestMapping("/admin")
    public String admin() {
        return "admin/index";
    }
    
    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
    
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("customer", new User());
        return "user/account_page";
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
    
    @PostMapping("/register")
    public String register(@ModelAttribute User customer) {
        if(userService.register(customer)) {
            return "redirect:/login?register_success";
        }
        return "redirect:/login?register_error";
    }
    
    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
