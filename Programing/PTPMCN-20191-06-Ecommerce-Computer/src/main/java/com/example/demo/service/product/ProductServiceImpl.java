package com.example.demo.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product findByCode(Integer code) {
		return productRepository.findByCode(code);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
    @Override
    public void deleteByCode(Integer id) {
        // TODO Auto-generated method stub
        
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
	

}
