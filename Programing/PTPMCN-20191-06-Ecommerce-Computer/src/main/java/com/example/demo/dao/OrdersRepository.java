package com.example.demo.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
	Optional<Orders> findById(int id);

	List<Orders> findAll();

	List<Orders> findByStatus(int status);
	
	long countByCreatingDateBetweenAndStatusNot(Date start, Date end, int status);
	
	List<Orders> findByCreatingDateBetweenAndStatusNot(Date start, Date end, int status);
	
	List<Orders> findByShipperId(int id);
	
	List<Orders> findByShipperIdAndStatus(int id, int status);
}
