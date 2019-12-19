package com.example.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.product.ProductService;

@Controller
@RequestMapping(path= "/user")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public String listProduct(Model model) {
		model.addAttribute("products", productService.findAll());
		return "user/index";
	}
}
