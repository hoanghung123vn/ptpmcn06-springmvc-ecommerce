package com.example.demo.service.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TypeRepository;
import com.example.demo.entity.Type;

/**
 * @author Hung Hoang
 * @version 1.0 Dec 19, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name TypeServiceImpl.java
 * @description TODO
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public long countAll() {
        return typeRepository.count();
    }

    @Override
	public Iterable<Type> findAll() {
		return typeRepository.findAll();
	}

}
