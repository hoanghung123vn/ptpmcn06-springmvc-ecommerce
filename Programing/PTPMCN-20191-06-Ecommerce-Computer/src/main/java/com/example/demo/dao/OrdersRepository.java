package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
	List<Orders> findAll();

	List<Orders> findByStatus(int status);
	
	long countByCreatingDateBetweenAndStatusNot(Date start, Date end, int status);
	
	List<Orders> findByCreatingDateBetweenAndStatusNot(Date start, Date end, int status);
}
