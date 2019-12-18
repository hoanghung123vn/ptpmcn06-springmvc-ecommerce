package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
	List<Orders> findAll();

	List<Orders> findByStatus(int status);
}
