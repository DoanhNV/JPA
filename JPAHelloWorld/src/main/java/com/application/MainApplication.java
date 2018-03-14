package com.application;

import com.dao.FighterDAO;
import com.entity.Fighter;

public class MainApplication {
	 public static void main(String[] args) {
		 FighterDAO fighterDAO = new FighterDAO();
		 // CREATE
		 fighterDAO.create(new Fighter("DoanhNV", 10));
		 // SELECT
		 Fighter selectFighter = fighterDAO.getById(1);
		 System.out.println(selectFighter);
		 // UPDATE
		 Fighter updateFighter = new Fighter(1,"Doanh ABC",11);
		 fighterDAO.update(updateFighter);
		 // DELETE
		 fighterDAO.delete(selectFighter);
	 }
}
