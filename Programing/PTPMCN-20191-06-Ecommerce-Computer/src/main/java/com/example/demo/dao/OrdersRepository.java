package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
	List<Orders> findAll();

	List<Orders> findByStatus(int status);
	
	List<Orders> findByShipperId(int id);
	
	List<Orders> findByShipperIdAndStatus(int id, int status);
}
