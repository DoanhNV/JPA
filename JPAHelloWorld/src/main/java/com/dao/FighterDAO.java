package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.entity.Fighter;

public class FighterDAO {
	private static EntityManager entityManager;
	private static final String PERSISTENCE_UNIT_NAME = "WarGameEM";
	
	public FighterDAO() {
		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}
	
	public Fighter getById(int id) {
		entityManager.getTransaction().begin();
		 Fighter fighter = entityManager.find(Fighter.class, id);
		entityManager.getTransaction().commit();
		return fighter;
	}
	
	public void create(Fighter fighter) {
		entityManager.getTransaction().begin();
		entityManager.persist(fighter);
		entityManager.getTransaction().commit();
	}
	
	public void update(Fighter fighter) {
		entityManager.getTransaction().begin();
		entityManager.merge(fighter);
		entityManager.getTransaction().commit();
	}
	
	public void delete(Fighter fighter) {
		entityManager.getTransaction().begin();
		entityManager.remove(fighter);
		entityManager.getTransaction().commit();
	}
}
