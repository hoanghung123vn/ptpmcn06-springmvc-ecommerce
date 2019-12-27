package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.entity.Type;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Type, Integer> {
    Type findById(int id);
    List<Type> findAll();
}