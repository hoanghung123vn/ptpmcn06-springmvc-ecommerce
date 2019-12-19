package com.example.demo.service.orders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrdersRepository;
import com.example.demo.entity.Orders;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersRepository ordersRepository;
	
	@Override
	public List<Orders> findAll() {
		return ordersRepository.findAll();
	}

	@Override
	public Optional<Orders> findById(int id) {
		return ordersRepository.findById(id);
	}

	@Override
	public Orders save(Orders orders) {
		return ordersRepository.save(orders);
	}

	@Override
	public List<Orders> findByStatus(int status) {
		return ordersRepository.findByStatus(status);
		
	}

	@Override
	public List<Orders> findByShipperId(int id) {
		// TODO Auto-generated method stub
		return ordersRepository.findByShipperId(id);
	}

	@Override
	public List<Orders> findByShipperIdAndStatus(int id, int status) {
		// TODO Auto-generated method stub
		return ordersRepository.findByShipperIdAndStatus(id, status);
	}

}
