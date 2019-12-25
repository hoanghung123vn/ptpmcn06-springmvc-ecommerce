package com.example.demo.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ManufacturerRepository;
import com.example.demo.dao.OrdersRepository;
import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Product;
import com.example.demo.service.product.ProductService;




@Controller
@RequestMapping(path= "")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrdersRepository ordersRepository;

	@Autowired
	ManufacturerRepository manufacturerRepository;
	
	@GetMapping("/view-details/{code}/")
	public String viewDetails(Model model, @PathVariable("code") String code) {
		int pcode = Integer.parseInt(code);
		model.addAttribute("product",  productService.findByCode(pcode));
		return "user/single_product";
	}

	@GetMapping("/view-quick/{code}/")
	public String viewQuick(Model model, @PathVariable("code") String code) {
		int pcode = Integer.parseInt(code);
		model.addAttribute("product", productService.findByCode(pcode));
		return "user/quick_view";
	}

	@GetMapping("/view-products/byManufacturer/{code}")
	public String viewProductsByManufacture(Model model, @PathVariable("code") String code){
		System.out.println(code);
		int mId = Integer.parseInt(code);
		Manufacturer m = manufacturerRepository.findById(mId);
		List<Product> products = productService.findByManufacturer(m);
		for (Product product : products) {
			System.out.println(product.getCode() + " - " + product.getManufacturer().getId());
		}
		model.addAttribute("products", products);
		return "user/product-manufacturer";
	}	

}
