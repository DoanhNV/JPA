package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import com.constant.Constant;

public class AbstractDAO {
	protected static EntityManager entityManager;
	public static CriteriaBuilder builder;
	static {
		entityManager = Persistence.createEntityManagerFactory(Constant.ENTITY_MANAGER_REFERENCE_NAME).createEntityManager();
		builder = entityManager.getCriteriaBuilder();
	}
}
