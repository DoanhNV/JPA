package com.dao;

import java.util.List;

import com.entity.Employee;
import com.entity.Store;

public class ShopDAO extends AbstractDAO {
		
	public void createStoreAndEmployee(List<Store> stores,Employee...employees) {
		entityManager.getTransaction().begin();
		for (Store store : stores) {
			entityManager.persist(store);
		}
		for (Employee employee : employees) {
			employee.setStores(stores);
			entityManager.persist(employee);
		}
		entityManager.getTransaction().commit();
	}
}
