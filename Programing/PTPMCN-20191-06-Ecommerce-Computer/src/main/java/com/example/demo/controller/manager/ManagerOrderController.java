package com.example.demo.controller.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Orders;
import com.example.demo.entity.User;
import com.example.demo.service.orders.OrdersService;
import com.example.demo.service.user.UserService;

@Controller
@RequestMapping("manager")
public class ManagerOrderController {

	@Autowired
	private OrdersService orderService;

	@Autowired
	private UserService userService;

	@GetMapping("/orders")
	public String listOrderStatusDaPhanCong(Model model,@RequestParam(value = "status", required = false) Integer status) {
		List<Orders> listOrders;
		if (status != null )
			listOrders = orderService.findByStatus(status);
		else
			listOrders = orderService.findAll();
		model.addAttribute("Orders", listOrders);
		model.addAttribute("shippers", userService.findAll());
		return "manager/orders";
	}

	@GetMapping("/orders/xacNhanDonHang")
	public String xacNhanDonHang(@RequestParam("id")int id) {
		Orders orders = orderService.findById(id).get();
		if (orders.getStatus() == 0) orders.setStatus(1);
		orderService.save(orders);
		return "redirect:/manager/orders?status=1";
	}

	@GetMapping("/orders/huyDonHang")
	public String huyDonHang(@RequestParam("id")int id) {
		Orders orders = orderService.findById(id).get();
		if (orders.getStatus() == 0) orders.setStatus(2);
		orderService.save(orders);
		return "redirect:/manager/orders?status=2";
	}

	@PostMapping("/orders/phanCongShipper")
	public String phanCongShipper(@RequestParam("orderId")int orderId, @RequestParam("shipperId")int shipperId) {
		if(shipperId == 0) {

		} else {
			Optional<Orders> order = orderService.findById(orderId);
			Optional<User> shipper = userService.findById(shipperId);
			order.get().setShipper(shipper.get());
			order.get().setStatus(3);
			orderService.save(order.get());
		}
		return "redirect:/manager/orders?status=3";
	}

	@GetMapping("/orders/hoanThanhDonHang")
	public String hoanThanhDonHang(@RequestParam("id")int id) {
		Orders orders = orderService.findById(id).get();
		if (orders.getStatus() == 4) orders.setStatus(5);
		orderService.save(orders);
		return "redirect:/manager/orders?status=2";
	}
}
