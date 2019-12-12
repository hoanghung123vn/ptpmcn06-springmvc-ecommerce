package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Manufacturer;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {

}
