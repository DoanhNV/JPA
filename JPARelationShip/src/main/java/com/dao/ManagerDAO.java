package com.dao;

import com.entity.Admin;
import com.entity.SubAdmin;

public class ManagerDAO extends AbstractDAO {
	
	public void createAdminAndSub(Admin admin,SubAdmin subAdmin) {
		entityManager.getTransaction().begin();
		entityManager.persist(admin);
		//
		System.out.println(admin.getId());
		//
		subAdmin.setManager(admin);
		entityManager.persist(subAdmin);
		entityManager.persist(new SubAdmin("Chào Doanh", admin));
		entityManager.getTransaction().commit();
	}
}
