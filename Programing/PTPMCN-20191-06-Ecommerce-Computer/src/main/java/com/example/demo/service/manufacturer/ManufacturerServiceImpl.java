package com.example.demo.service.manufacturer;

<<<<<<< HEAD
import java.util.List;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
>>>>>>> develop

import com.example.demo.dao.ManufacturerRepository;
import com.example.demo.entity.Manufacturer;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

=======
>>>>>>> develop
@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	ManufacturerRepository manufacturerRepository;

	@Override
<<<<<<< HEAD
	public Manufacturer findById(int id) {
		return manufacturerRepository.findById(id);
	}

	@Override
	public List<Manufacturer> findAll() {
		return manufacturerRepository.findAll();
	}

	

=======
	public Iterable<Manufacturer> findAll() {
		return manufacturerRepository.findAll();
	}

>>>>>>> develop
}
