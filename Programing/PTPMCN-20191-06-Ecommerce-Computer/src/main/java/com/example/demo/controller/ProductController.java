package com.example.demo.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Product;

@Controller
public interface ProductController extends CrudRepository<Product, Integer>{
	Product findByProductName(String name);
	List<Product> findByIdManufacturer(Integer idManufacturer);
	List<Product> findByIdType(Integer idType);
}
