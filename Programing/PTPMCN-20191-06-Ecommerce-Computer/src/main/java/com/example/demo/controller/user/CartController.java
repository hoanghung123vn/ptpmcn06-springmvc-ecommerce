package com.example.demo.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.product.ProductService;
import com.example.demo.service.user.UserService;


@Controller
@RequestMapping(path = "/user")
public class CartController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User currentUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = currentUser.getUsername();
		User user = userService.findByEmail(email);
		return user;
	}
	
	@GetMapping("/cart")
	public String viewCart(Model model) {
		return "user/shopping_cart";
	}
	
	@GetMapping("/cart/addProduct")
	public @ResponseBody String addProduct(@RequestParam(name = "productCode", required = false) String productCode) {
		int code = Integer.parseInt(productCode); // get code sent from addProduct request
		Product product = productService.findByCode(code);
		try {
			User user = getCurrentUser();
			Cart item = new Cart();
			item.setCustomer(user);
			item.setProduct(product);
			item.setPrice(product.getStandardPrice());
			item.setQuantity(1);
			user.addItemCart(item);
			userService.save(user);
			return "success";
		} catch (Exception e) {
			return "failed";
		}
	}

	@GetMapping("/cart/removeProduct")
	public @ResponseBody String removeProduct(@RequestParam(name = "productCode", required = false) String productCode){
		int code = Integer.parseInt(productCode); // get code sent from addProduct request
		System.out.println("code: " + code);
		try {
			User user = getCurrentUser();
			user.removeItemCart(code);
			System.out.println("items: " + user.getItems().size());
			userService.save(user);
			return "success";
		} catch (Exception e) {
			return "failed";
		}
	}

	
	@GetMapping("/cart/checkout")
	public String checkout(Model model) {
		return "user/checkout";
	}
	
	@RequestMapping(value = "/cart/checkout", method = RequestMethod.POST)
	public String checkout(@ModelAttribute("currentUser") User user) {
		
		User newUser = getCurrentUser();
		List<Cart> items = user.getItems();
		newUser.updateItems(items);
		userService.save(newUser);
		return "redirect:/user/cart/checkout";
	}
	
	
}
