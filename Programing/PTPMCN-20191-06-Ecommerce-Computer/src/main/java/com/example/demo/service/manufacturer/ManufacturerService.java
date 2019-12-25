package com.example.demo.service.manufacturer;

import com.example.demo.dao.ManufacturerRepository;
import com.example.demo.entity.Manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ManufacturerService{
    @Autowired
    ManufacturerRepository manufacturerRepository;

    Manufacturer findById(int id){
        return manufacturerRepository.findById(id);
    }
}