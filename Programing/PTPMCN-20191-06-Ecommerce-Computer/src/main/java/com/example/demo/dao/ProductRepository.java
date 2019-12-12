package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Override
	List<Product> findAll();

	Optional<Product> findByCode(int code);
}
