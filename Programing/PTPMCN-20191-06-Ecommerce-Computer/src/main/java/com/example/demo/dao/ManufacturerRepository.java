package com.example.demo.dao;

<<<<<<< HEAD
import com.example.demo.entity.Manufacturer;

import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {
    public Manufacturer findById(int id);
}
=======
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Manufacturer;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {

}
>>>>>>> c6930de170422d9471435fff5042327488c246a2
