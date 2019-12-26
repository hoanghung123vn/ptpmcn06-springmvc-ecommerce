package com.example.demo.service.product;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findByCode(int code);

	void save(Product product);

	void deleteByCode(Integer id);
	void addProduct(Product product);
	
	long countAll();
	
	List<Product> findTop5BestSeller(); 
}
