package com.dao;


import com.entity.Bird;
import com.entity.Forest;

public class ForestDAO extends AbstractDAO {
	
	public void create(Forest forest, Bird bird) {
		entityManager.getTransaction().begin();
		entityManager.persist(forest);
		forest.setBirds(bird);
		entityManager.persist(bird);
		bird.setForest(forest);
		entityManager.getTransaction().commit();
	}
}
