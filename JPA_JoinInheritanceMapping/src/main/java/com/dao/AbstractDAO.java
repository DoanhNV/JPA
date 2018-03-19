package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AbstractDAO {
	protected static EntityManager entityManager;
	private static final String PERSITENCE_CONTEXT_NAME = "joinInheritanceMappingEM";
	static {
		entityManager = Persistence.createEntityManagerFactory(PERSITENCE_CONTEXT_NAME).createEntityManager();
	}
}
