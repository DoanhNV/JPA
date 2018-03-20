package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class AbstractDAO {
	protected static EntityManager entityManager;
	private static final String PERSISTENCE_MANAGER_NAME = "criteriaEM";
	protected CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	static {
		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_MANAGER_NAME).createEntityManager();
	}
}
