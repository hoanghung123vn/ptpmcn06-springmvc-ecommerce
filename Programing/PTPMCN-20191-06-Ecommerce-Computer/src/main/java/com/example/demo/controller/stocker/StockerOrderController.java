package com.example.demo.controller.stocker;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Orders;
import com.example.demo.service.orders.OrdersService;

@Controller
@RequestMapping(path = "/stocker")
public class StockerOrderController {
	
	@Autowired
	private OrdersService orderService;
	
	/**
	 * list order in 2 way:
	 * if no parameter, see all orders
	 * if parameter status, see all orders of that status
	 * 
	 * @param model
	 * @param status
	 * @return orders list
	 */
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
	
	/**
	 * change the status of order from "Da Phan cong" to "tren duong van chuyen"
	 * return page to see all order
	 * 
	 * @param id
	 * @return page to see all order
	 */
	@GetMapping("/order/xacNhanGiaoHang")
	public String changeStatusOrders34(@RequestParam("id")int id) {
		Orders orders = orderService.findById(id).get();
		if (orders.getStatus() == 3) orders.setStatus(4);
		orderService.save(orders);
		return "redirect:/stocker/orders";
	}
	
	/**
	 * change the status of order from "tren duong van chuyen" to "hoan thanh"
	 * return page to see all order
	 * 
	 * @param id
	 * @return page to see all order
	 */
	@GetMapping("/order/hoanThanh")
	public String changeStatusOrders45(@RequestParam("id")int id) {
		Orders orders = orderService.findById(id).get();
		if (orders.getStatus() == 4) orders.setStatus(5);
		orderService.save(orders);
		return "redirect:/stocker/orders";
	}
	
	/**
	 * save the changed order and return html to see result
	 * 
	 * @param id
	 * @return html to see result
	 */
	@GetMapping("/receiveProduct")
	public String changeItemsOrders(@ModelAttribute("order") Orders order) {
		Orders old = orderService.findById(order.getId()).get();
		for (int i = 0; i< order.getItems().size();i++) {
			old.getItems().get(i).setQuantity(order.getItems().get(i).getQuantity());
		}
		
		orderService.save(old);
		return "redirect:/stocker/orders?status=4";
	}
	
	/**
	 * get form present the quantity of Product be changed
	 * 
	 * @param model
	 * @param id
	 * @return html_Page to enter information changed
	 */
	@GetMapping("/order/receiveProduct")
	public String getFormReceive(Model model, @RequestParam("id")int id) {
		System.out.println(id);
		Orders order = orderService.findById(id).get();
		System.out.println(order.getShipAddress());
		model.addAttribute("order", order);
		return "stocker/receiveProduct";
	}
	
	/**
	 * to html to see detail of a order
	 * 
	 * @param model
	 * @param id
	 * @return html_page to see detail of order
	 */
	@GetMapping("/orderDetail")
	public String getDetailOrder(Model model,@RequestParam("id")int id) {
		Orders order = orderService.findById(id).get();
		model.addAttribute("order", order);
		return "stocker/order";
	}
	
}
