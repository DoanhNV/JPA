package com.lazyloading.application;

import com.lazyloading.dao.HouseDAO;
import com.lazyloading.entity.House;

public class MainApp {
	public static void main(String[] args) {
		HouseDAO houseDAO = new HouseDAO();
		Byte[] pic = new Byte[1];
		byte a = 8;
		pic[0] = new Byte(a);
		System.out.println(pic);
		houseDAO.insert(new House("bed room", 4,pic));
		House house = houseDAO.findById(1);
		System.out.println(house);
		houseDAO.closeEntityManager();
	}
}
