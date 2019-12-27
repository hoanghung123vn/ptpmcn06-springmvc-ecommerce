package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Type;
import com.example.demo.entity.User;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class CurrentUserAdvice {
	
	@Autowired
	UserService userService;

	@Autowired
	CategoryService categoryService;

	@ModelAttribute("categorys")
	public List<Type> currentOriginals() {
		try {
			return categoryService.findAll();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@ModelAttribute("currentUser")
	public User currentUser() {
		try {
			if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof String) {
				return null;
			}
			org.springframework.security.core.userdetails.User currentUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String email = currentUser.getUsername();
			User user = userService.findByEmail(email);
			return user;
		} catch (Exception e) {
			return null;
		}
		
	}

	
}
