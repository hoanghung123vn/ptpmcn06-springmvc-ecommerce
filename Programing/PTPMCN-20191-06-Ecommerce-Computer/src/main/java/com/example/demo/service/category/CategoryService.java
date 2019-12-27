package com.example.demo.service.category;

import java.util.List;

import com.example.demo.entity.Type;

public interface CategoryService {
    Type findById(int id);
    List<Type> findAll();
    
}