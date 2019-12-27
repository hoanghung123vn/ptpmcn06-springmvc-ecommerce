package com.example.demo.service.product;

import java.util.List;

import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Product;
import com.example.demo.entity.Type;

public interface ProductService {

	List<Product> findAll();

	Product findByCode(int code);

	void save(Product product);

	void deleteByCode(Integer id);
	void addProduct(Product product);
	long countAll();
	List<Product> findByManufacturer(Manufacturer manufacturer);

	List<Product> findByCategory(Type category);
	
	List<Product> findTop5BestSeller(); 
}
