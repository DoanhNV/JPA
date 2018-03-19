package com.dao;

import com.entity.Dog;

public class DogDAO extends AbstractDAO {
	
	public void create(Dog dog1,Dog dog2) {
		entityManager.getTransaction().begin();
		entityManager.persist(dog1);
		entityManager.persist(dog2);
		entityManager.getTransaction().commit();
	}
}
