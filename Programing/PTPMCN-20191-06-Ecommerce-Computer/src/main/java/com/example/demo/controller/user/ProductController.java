package com.example.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.OrdersRepository;
import com.example.demo.service.product.ProductService;

@Controller
@RequestMapping(path= "")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@GetMapping("/view-details/{code}/")
	public String viewDetails(Model model, @PathVariable("code") String code) {
		System.out.println(code);
		int pcode = Integer.parseInt(code);
		model.addAttribute("product",  productService.findByCode(pcode));
		return "user/single_product";
	}

	@GetMapping("/view-quick/{code}/")
	public String viewQuick(Model model, @PathVariable("code") String code) {
		 System.out.println(code);
		 int pcode = Integer.parseInt(code);
		 model.addAttribute("product",  productService.findByCode(pcode));
		return "user/quick_view";
	}
	
	
	
	
	
	
}
