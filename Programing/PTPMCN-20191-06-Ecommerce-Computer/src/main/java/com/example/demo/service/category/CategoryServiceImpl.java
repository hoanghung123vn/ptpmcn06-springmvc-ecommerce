package com.example.demo.service.category;

import java.util.List;

import com.example.demo.dao.CategoryRepository;
import com.example.demo.entity.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepo;

    @Override
    public Type findById(int id) {
        return categoryRepo.findById(id);
    }

    @Override
    public List<Type> findAll() {
        return categoryRepo.findAll();
    }

}