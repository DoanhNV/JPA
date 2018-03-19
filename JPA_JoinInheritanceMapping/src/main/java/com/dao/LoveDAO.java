package com.dao;

import com.entity.ChocolateLove;
import com.entity.Love;
import com.entity.PhiliaLove;

public class LoveDAO  extends AbstractDAO {
	
	public void create(ChocolateLove chocolateLove, PhiliaLove philiaLove,Love love) {
		entityManager.getTransaction().begin();
		entityManager.persist(chocolateLove);
		entityManager.persist(philiaLove);
		entityManager.persist(love);
		entityManager.getTransaction().commit();
	}
}
