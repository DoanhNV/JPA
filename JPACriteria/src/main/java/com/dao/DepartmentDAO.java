package com.dao;

import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import com.entity.Department;

public class DepartmentDAO extends AbstractDAO {

	public void create(Department department) {
		entityManager.getTransaction().begin();
		entityManager.persist(department);
		entityManager.getTransaction().commit();
	}

	public void delete(int id) {
		entityManager.getTransaction().begin();
		CriteriaDelete<Department> deleter = builder.createCriteriaDelete(Department.class);
		Root<Department> root = deleter.from(Department.class);
		deleter.where(builder.equal(root.get("id"),id));
		entityManager.createQuery(deleter).executeUpdate();
		entityManager.getTransaction().commit();
	}

}
