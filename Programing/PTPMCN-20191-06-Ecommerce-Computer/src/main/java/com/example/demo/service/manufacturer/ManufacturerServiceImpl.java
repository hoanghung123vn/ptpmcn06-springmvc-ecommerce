package com.example.demo.service.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ManufacturerRepository;
import com.example.demo.entity.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	ManufacturerRepository manufacturerRepository;

	@Override
	public Iterable<Manufacturer> findAll() {
		return manufacturerRepository.findAll();
	}

}
