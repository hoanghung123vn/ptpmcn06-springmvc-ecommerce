package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	List<Product> findAll();
	
	Product findByProductName(String name);

	Product findByCode(int code);

	List<Product> findByManufacturer(Manufacturer manfacturer);
}
