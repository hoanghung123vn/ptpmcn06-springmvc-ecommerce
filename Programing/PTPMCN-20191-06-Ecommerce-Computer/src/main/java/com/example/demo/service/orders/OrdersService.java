package com.example.demo.service.orders;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Orders;

public interface OrdersService {
	List<Orders> findAll();
	Optional<Orders> findById(int id);
	Orders save(Orders orders);
	List<Orders> findByStatus(int status);
	
	long countOrderInDay();
	
	long countOrderInWeek();
	
	long countOrderInMonth();
	
	long countOrderInYear();
	
	long sumPriceOrdersInDay();
	
	long sumPriceOrdersInWeek();
	
	long sumPriceOrdersInMonth();
	
	long sumPriceOrdersInYear();
}
