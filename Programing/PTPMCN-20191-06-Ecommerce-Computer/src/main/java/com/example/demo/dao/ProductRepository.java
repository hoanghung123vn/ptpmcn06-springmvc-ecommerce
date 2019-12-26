package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Override
	List<Product> findAll();

	Product findByCode(int code);

	List<Product> findByManufacturer(Manufacturer manfacturer);
    Product findByProductName(String name);

    @Query(value = "select p.*, sum(po.quantity) as total_quantity from product p "
            + "inner join order_detail po on p.code = po.product_code group by p.code, p.product_name "
            + "order by total_quantity desc limit 5", nativeQuery = true)
    List<Product> findTop5BestSeller();
}
