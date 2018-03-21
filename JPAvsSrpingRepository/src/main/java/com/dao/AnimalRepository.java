package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer>  {
	
	public Animal findById(int id);
}
