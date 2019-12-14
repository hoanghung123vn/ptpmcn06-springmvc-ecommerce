package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
	List<Order> findAll();
}
