package com.example.demo.controller.stocker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Orders;
import com.example.demo.service.orders.OrdersService;

import net.bytebuddy.asm.Advice.Return;

@Controller
@RequestMapping(path = "/stocker")
public class StockerOrderController {
	
	@Autowired
	private OrdersService orderService;
	
	@GetMapping("/orders")
	public String listOrderStatusDaPhanCong(Model model,@RequestParam(value = "status", required = false)Integer status) {
		List<Orders> listOrders;
		if (status != null )
			listOrders = orderService.findByStatus(status);
		else 
			listOrders = orderService.findAll();
		model.addAttribute("Orders", listOrders);
		return "stocker/listOrder";
	}
	

	@GetMapping("/order/save")
	public String changeStatusOrders(@RequestParam("id")int id) {
		Orders orders = orderService.findById(id);
		if (orders.getStatus() == 3) orders.setStatus(4);
		orderService.save(orders);
		return "redirect:/stocker/orders";
	}
}
