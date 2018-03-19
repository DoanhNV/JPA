package com.dao;

import com.entity.Money;

public class MoneyDAO extends AbstractDAO {

	public void create(Money money1, Money money2, Money money3) {
		entityManager.getTransaction().begin();
		entityManager.persist(money1);
		entityManager.persist(money2);
		entityManager.persist(money3);
		entityManager.getTransaction().commit();
	}
	
	public void create2(Money money1, Money money2) {
		entityManager.getTransaction().begin();
		entityManager.persist(money1);
		entityManager.persist(money2);
		entityManager.getTransaction().commit();
	}
}
