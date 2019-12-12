package com.example.demo.controller.manager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Origin;
import com.example.demo.entity.Product;
import com.example.demo.entity.Type;
import com.example.demo.service.manufacturer.ManufacturerService;
import com.example.demo.service.origin.OriginService;
import com.example.demo.service.product.ProductService;
import com.example.demo.service.type.TypeService;

@Controller
@RequestMapping("manager/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	ManufacturerService manufacturerService;

	@Autowired
	TypeService typeService;

	@Autowired
	OriginService originService;

	@GetMapping("/list")
    public String listProducts(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
        return "manager/products/list-products";
    }

	@GetMapping("/details")
	public String details(@RequestParam("code") int code,
									Model model) {
		Product product = productService.findByCode(code);
		model.addAttribute("product", product);
		return "manager/products/product-details";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Product product = new Product();

		model.addAttribute("product", product);

		Iterable<Manufacturer> manufacturers = manufacturerService.findAll();
		model.addAttribute("manufacturers", manufacturers);

		Iterable<Type> types = typeService.findAll();
		model.addAttribute("types", types);

		Iterable<Origin> origins = originService.findAll();
		model.addAttribute("origins", origins);

		return "manager/products/product-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("code") int code,
									Model model) {

		Product product = productService.findByCode(code);

		model.addAttribute("product", product);

		Iterable<Manufacturer> manufacturers = manufacturerService.findAll();
		model.addAttribute("manufacturers", manufacturers);

		Iterable<Type> types = typeService.findAll();
		model.addAttribute("types", types);

		Iterable<Origin> origins = originService.findAll();
		model.addAttribute("origins", origins);

		return "manager/products/product-form";
	}


	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile fileData) {
		if(!fileData.isEmpty()) {
			// Thư mục gốc upload file.
	        String uploadRootPath = "src/main/resources/static/products";
	        System.out.println("uploadRootPath=" + uploadRootPath);

	        File uploadRootDir = new File(uploadRootPath);
	        // Tạo thư mục gốc upload nếu nó không tồn tại.
	        if (!uploadRootDir.exists()) {
	            uploadRootDir.mkdirs();
	        }
	            // Tên file gốc tại Client.
	        String name = fileData.getOriginalFilename();
	        System.out.println("Client File Name = " + name);

	        if (name != null && name.length() > 0) {
	            try {
	                // Tạo file tại Server.
	                File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

	                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
	                stream.write(fileData.getBytes());
	                stream.close();
	                System.out.println("Write file: " + serverFile);
	            } catch (Exception e) {
	                System.out.println("Error Write file: " + name);
	            }
	        }
	        product.setImageLink("/products/" + name);
		}

		productService.save(product);

		return "redirect:/manager/products/details?code=" + product.getCode();
	}


	@GetMapping("/delete")
	public String delete(@RequestParam("code") int code) {

		productService.deleteByCode(code);

		return "redirect:/manager/products/list";

	}
}
