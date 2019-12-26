package com.example.demo.dao;


import java.util.List;
import com.example.demo.entity.Manufacturer;

import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {
    public Manufacturer findById(int id);
    public List<Manufacturer> findAll();
}

