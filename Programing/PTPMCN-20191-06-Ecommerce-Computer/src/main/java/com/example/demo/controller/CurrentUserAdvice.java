package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.User;
import com.example.demo.service.user.UserService;

@ControllerAdvice
public class CurrentUserAdvice {
	
	@Autowired
	UserService userService;
	
	@ModelAttribute("currentUser")
	public User currentUser() {
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof String) {
			return null;
		}
		org.springframework.security.core.userdetails.User currentUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = currentUser.getUsername();
		User user = userService.findByEmail(email);
		return user;
	}
}
