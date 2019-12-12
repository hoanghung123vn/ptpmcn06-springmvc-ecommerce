package com.example.demo.service.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TypeRepository;
import com.example.demo.entity.Type;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	TypeRepository typeRepository;

	public Iterable<Type> findAll() {
		return typeRepository.findAll();
	}
}
