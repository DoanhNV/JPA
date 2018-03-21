package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AnimalRepository;
import com.entity.Animal;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public Animal findById(int id) {
		return animalRepository.findById(id);
	}
	
	@Transactional
	public void save(Animal animal) {
		animalRepository.save(animal);
	} 
	
	@Transactional
	public void delete(int id) {
		animalRepository.deleteById(id);
	}
	
	public List<Animal> listAll() {
		List<Animal> animals = new ArrayList<Animal>();
		Iterable<Animal> iterable = animalRepository.findAll();
		for (Animal animal : iterable) {
			animals.add(animal);
		}
		return animals;
	}
}
