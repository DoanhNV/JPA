package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AbstractDAO {
	protected EntityManager entityManager;
	private static final String PERSISTENCE_MANAGER_NAME = "criteriaEM";
	static {
		Persistence.createEntityManagerFactory(PERSISTENCE_MANAGER_NAME).createEntityManager();
	}
}
