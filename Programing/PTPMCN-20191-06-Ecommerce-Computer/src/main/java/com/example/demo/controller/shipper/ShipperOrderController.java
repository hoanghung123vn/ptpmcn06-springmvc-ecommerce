package com.example.demo.controller.shipper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Orders;
import com.example.demo.service.orders.OrdersService;

@Controller
@RequestMapping(path = "/shipper")
public class ShipperOrderController {

	@Autowired
	private OrdersService orderService;
	
	@GetMapping("/orders")
	public String listOrderStatusDaPhanCong(Model model,
			@RequestParam(value = "status", required = false)Integer status,
			@RequestParam(value = "id", required = false) Integer id_shipper) {
		List<Orders> listOrders;

		int s = 0, i = 0;
		if (status != null) s = 1;
		if (id_shipper != null) i =1;
		int si = s+i;
		switch (si) {
		case 0:
			listOrders = orderService.findAll();
			break;
			
		case 2:
			listOrders = orderService.findByShipperIdAndStatus(id_shipper, status);
			break;
		case 1:
			if (s==1) listOrders = orderService.findByStatus(status);
			else listOrders = orderService.findByShipperId(id_shipper);
			break;
		default:
			listOrders = null;
			break;
		}
		model.addAttribute("Orders", listOrders);
		return "shipper/listOrder";
	}
}
