package com.example.demo.service.origin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OriginRepository;
import com.example.demo.entity.Origin;

@Service
public class OriginServiceImpl implements OriginService {

	@Autowired
	OriginRepository originRepository;

	@Override
	public Iterable<Origin> findAll() {
		return originRepository.findAll();
	}

}
