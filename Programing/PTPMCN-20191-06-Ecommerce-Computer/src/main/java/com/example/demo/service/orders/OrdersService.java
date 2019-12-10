package com.example.demo.service.orders;

import java.util.List;

import com.example.demo.entity.Orders;

public interface OrdersService {
	List<Orders> findAll();
	Orders findById(int id);
	Orders save(Orders orders);
	List<Orders> findByStatus(int status);
}
