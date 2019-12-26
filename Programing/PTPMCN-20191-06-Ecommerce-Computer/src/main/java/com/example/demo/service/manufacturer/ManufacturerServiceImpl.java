package com.example.demo.service.manufacturer;

import java.util.List;

import com.example.demo.dao.ManufacturerRepository;
import com.example.demo.entity.Manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	ManufacturerRepository manufacturerRepository;

	@Override
	public Manufacturer findById(int id) {
		return manufacturerRepository.findById(id);
	}

	@Override
	public List<Manufacturer> findAll() {
		return manufacturerRepository.findAll();
	}

	

}
