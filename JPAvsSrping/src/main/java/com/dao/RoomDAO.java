package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

import com.entity.Room;

public class RoomDAO {

	private EntityManager entityManager;
	private CriteriaBuilder builder;
	public RoomDAO() {

	}
	
	public RoomDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public void create(Room room) {
		entityManager.persist(room);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public CriteriaBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(CriteriaBuilder builder) {
		this.builder = builder;
	}

}
