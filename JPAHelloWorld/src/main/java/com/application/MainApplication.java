package com.application;

import com.dao.FighterDAO;
import com.entity.Fighter;

public class MainApplication {
	 public static void main(String[] args) {
		 FighterDAO fighterDAO = new FighterDAO();
		 fighterDAO.create(new Fighter("DoanhNV", 10));
		 System.out.println(fighterDAO.getById(1));
	}
}
