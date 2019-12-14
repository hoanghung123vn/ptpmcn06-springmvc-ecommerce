package com.example.demo.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import com.example.demo.service.user.UserService;

@Controller
@RequestMapping(path = "/user")
public class CartController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/cart/{id}")
	public String viewCart(Model model, @PathVariable("id") Integer id) {
		User userInfor = userService.findById(id).get();
		System.out.println(userInfor);
		model.addAttribute("user", userInfor);
		return "user/shopping_cart";
	}
	
	@GetMapping("/cart/checkout")
	public String checkout() {
		return "user/checkout";
	}
	
	@RequestMapping(value = "/cart/checkout", method = RequestMethod.POST)
	public String checkout(@ModelAttribute("user") User user, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("userId"));
		List<Cart> items = user.getItems();
		User newUser = userService.findById(id).get();
		System.out.println("new user: " + newUser);
//		System.out.println("old user: " + user);
//		for (Cart cart : items) {
//			
//		}
//		newUser.setItems(items);
		userService.save(newUser);
		return "redirect:/user/cart/checkout";
	}
	
}
