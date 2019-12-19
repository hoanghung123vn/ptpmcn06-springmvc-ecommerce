package com.example.demo.service.orders;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Orders;

public interface OrdersService {
	List<Orders> findAll();
	Optional<Orders> findById(int id);
	Orders save(Orders orders);
	List<Orders> findByStatus(int status);
	List<Orders>  findByShipperId(int id);
	List<Orders> findByShipperIdAndStatus(int id, int status);
}
