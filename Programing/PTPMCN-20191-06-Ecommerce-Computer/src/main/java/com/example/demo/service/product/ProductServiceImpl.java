package com.example.demo.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findByCode(int code) {
		Optional<Product> result = productRepository.findByCode(code);

		Product product = null;

		if (result.isPresent()) {
			product = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find product code - " + code);
		}

		return product;
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

}
