package com.example.demo.service.manufacturer;

import java.util.List;

import com.example.demo.entity.Manufacturer;

import org.springframework.stereotype.Service;

@Service
public interface ManufacturerService{
    Manufacturer findById(int id);

<<<<<<< HEAD
    List<Manufacturer> findAll();
=======
    Manufacturer findById(int id){
        return manufacturerRepository.findById(id);
    }
>>>>>>> develop
}
