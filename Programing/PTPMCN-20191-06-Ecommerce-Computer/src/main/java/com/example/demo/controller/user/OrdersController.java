package com.example.demo.controller.user;

import java.util.Date;

import com.example.demo.dao.OrdersRepository;
import com.example.demo.entity.Orders;
import com.example.demo.entity.User;
import com.example.demo.service.product.ProductService;
import com.example.demo.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/user")
public class OrdersController {
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrdersRepository orderService;
	
	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User currentUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = currentUser.getUsername();
		User user = userService.findByEmail(email);
		return user;
	}
	
	 @GetMapping("/orders")
	 public String getOrders() {
	 	return "user/list-orders";
	 }

	@PostMapping("/orders")
	public String getOrders(@ModelAttribute("currentUser") User currentUser, Model model) {
		Date now = new Date();
		User user = getCurrentUser();
		user.setAddress(currentUser.getAddress());
		user.setName(currentUser.getName());
		user.setPhone(currentUser.getPhone());
		user.setTaxCode(user.getTaxCode());
		
		// create new order
		Orders order =  new Orders();
		order.setCreatingDate(now);
		order.setShipDate(new Date(now.getTime() + 86400*1000*3));
		order.setCustomer(user);
		order.setItems(user.convertCartToOrdersDetail(order));
		order.setShipAddress(user.getAddress());
		order.setStatus(0);
		
		user.addOrderOfCustomer(order);
		user.EmptyCart();
		userService.save(user);
		orderService.save(order);

		model.addAttribute("newOrder", order);
		
		return "user/list-orders";
	}	

	@GetMapping("/orders/cancelOrder")
	public @ResponseBody String cancelOrder(@RequestParam(name = "orderId", required = true) String orderId){
		System.out.println(orderId);
		try {
			User user = getCurrentUser();
			int oId = Integer.parseInt(orderId);
			Orders order = orderService.findById(oId).get();

			user.removeOrderofCustomer(order);
			orderService.delete(order);
			userService.save(user);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
}
