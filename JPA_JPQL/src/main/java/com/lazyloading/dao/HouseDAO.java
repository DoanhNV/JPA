package com.lazyloading.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lazyloading.entity.House;

public class HouseDAO {
	private EntityManager entityManager;
	private static final String PERSISTENCE_FILE_NAME = "jpqlEM";
	
	public HouseDAO() {
		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_FILE_NAME).createEntityManager();
	}
	
	public House findById(int id) {
		TypedQuery<House> query = entityManager.createNamedQuery("find house by id", House.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public void insert(House house) {
		entityManager.getTransaction().begin();
		entityManager.persist(house);
		entityManager.getTransaction().commit();
	}
	
	public void closeEntityManager() {
		entityManager.close();
	}
}
