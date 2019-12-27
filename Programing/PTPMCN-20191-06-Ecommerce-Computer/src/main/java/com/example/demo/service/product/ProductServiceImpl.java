package com.example.demo.service.product;

import java.util.List;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Product;
import com.example.demo.entity.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product findByCode(int code) {
		return productRepository.findByCode(code);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteByCode(Integer code) {
		productRepository.deleteById(code);
	}

	@Override
	public void addProduct(Product product) {

	}

	@Override
	public long countAll() {
		return productRepository.count();
	}

	@Override
	public List<Product> findByManufacturer(Manufacturer manufacturer) {
		return productRepository.findByManufacturer(manufacturer);
	}

	@Override
	public List<Product> findTop5BestSeller() {
		return productRepository.findTop5BestSeller();
	}

	@Override
	public List<Product> findByCategory(Type category) {
		return productRepository.findByType(category);
	}

}
