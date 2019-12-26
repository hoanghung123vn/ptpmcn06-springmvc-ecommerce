package com.example.demo.service.manufacturer;

import java.util.List;

import com.example.demo.entity.Manufacturer;

import org.springframework.stereotype.Service;

@Service
public interface ManufacturerService{
    List<Manufacturer> findAll();
    
    Manufacturer findById(int id);
}
