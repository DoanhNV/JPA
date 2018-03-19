package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class AbstractDAO {
	protected static final EntityManager entityManager;
	private static final String PERSISTENCE_NAME = "relationshipEM";

	static {
		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_NAME).createEntityManager();
	}
}
