package com.application;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.config.ApplicationConfig;
import com.entity.Animal;
import com.service.AnimalService;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AnimalService animalService = context.getBean(AnimalService.class);
		
		// INSERT
		Animal createAnimal = new Animal(4, "pig");
		animalService.save(createAnimal);
		
		// FIND
		Animal animal = animalService.findById(1);
		System.out.println(animal);
		
		// LIST ALL
		List<Animal> animals = animalService.listAll();
		System.out.println(animals);
		
		// UPDATE
		Animal updateAnimal = new Animal(2, "cat");
		updateAnimal.setId(1);
		animalService.save(updateAnimal);
		
		// DELETE
		animalService.delete(4);
		context.close();
	}	
}
