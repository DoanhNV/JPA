package com.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;

import com.entity.User;

public class UserDAO extends AbstractDAO {
	
	public void create() {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaUpdate<User> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(User.class);
		/*https://www.concretepage.com/hibernate-4/hibernate-4-criteria-query-tutorials-with-examples-using-jpa-2*/
		/*https://www.thoughts-on-java.org/criteria-updatedelete-easy-way-to/*/
	}
}
