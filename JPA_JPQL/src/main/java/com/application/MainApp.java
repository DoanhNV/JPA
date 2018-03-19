package com.application;

import com.dao.HouseDAO;
import com.entity.House;

public class MainApp {
	public static void main(String[] args) {
		HouseDAO houseDAO = new HouseDAO();
		houseDAO.insert(new House("bed room", 4));
		House house = houseDAO.findById(1);
		System.out.println(house);
		houseDAO.closeEntityManager();
	}
}
