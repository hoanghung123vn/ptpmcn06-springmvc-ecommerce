package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Hung Hoang
 * @version 1.0 Nov 16, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Thi Thu Trang Nguyen
 * @class_name MainController.java
 * @description TODO
 */
@Controller
@RequestMapping(path = "/")
public class MainController {
    @GetMapping("/")
    public String user() {
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
    public String login(){
        return "user/account_page";
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}
