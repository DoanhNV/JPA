package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.entity.Chair;
import com.entity.Desk;

public class SchoolDAO extends AbstractDAO {
	
	public void createTableAndChair(Desk desk, Chair...chairs) {
		entityManager.getTransaction().begin();
		List<Chair> listChair = new ArrayList<Chair>();
		for (Chair chair : chairs) {
			listChair.add(chair);
			entityManager.persist(chair);
		}
		desk.setChairs(listChair);
		entityManager.persist(desk);
		entityManager.getTransaction().commit();
	}
}
