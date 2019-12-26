package com.example.demo.controller.shipper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Orders;
import com.example.demo.entity.User;
import com.example.demo.service.orders.OrdersService;
import com.example.demo.service.user.UserService;

@Controller
@RequestMapping(path = "/shipper")
public class ShipperOrderController {

	@Autowired
	UserService userService;
	
	@Autowired
	private OrdersService orderService;
	
	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User currentUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = currentUser.getUsername();
		User user = userService.findByEmail(email);
		return user;
	}
	
	@GetMapping("/orders")
	public String listOrderStatusDaPhanCong(Model model,
			@RequestParam(value = "status", required = false)Integer status
			) {
		List<Orders> listOrders;
		User shipper = getCurrentUser();
		int s = 0, i = 0;
		if (status != null) s = 1;
		if (shipper != null ) i =1;
		int si = s+i;
		switch (si) {
		case 0:
			listOrders = orderService.findAll();
			break;
			
		case 2:
			listOrders = orderService.findByShipperIdAndStatus(shipper.getId(), status);
			break;
		case 1:
			if (s==1) listOrders = orderService.findByStatus(status);
			else listOrders = orderService.findByShipperId(shipper.getId());
			break;
		default:
			listOrders = null;
			break;
		}
		model.addAttribute("Orders", listOrders);
		return "shipper/listOrder";
	}
}
