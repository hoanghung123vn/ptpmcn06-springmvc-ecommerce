package com.example.demo.service.product;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	Product findByCode(Integer code);
	List<Product> findAll();
	void deleteByCode(Integer id);
	void addProduct(Product product);
	
	long countAll();
	
	List<Product> findTop5BestSeller(); 
}
