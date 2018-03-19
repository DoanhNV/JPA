package com.application;

import com.dao.DogDAO;
import com.dao.ForestDAO;
import com.dao.LoveDAO;
import com.dao.MoneyDAO;
import com.entity.Bird;
import com.entity.ChocolateLove;
import com.entity.Dog;
import com.entity.Dollar;
import com.entity.Forest;
import com.entity.HouseDog;
import com.entity.Love;
import com.entity.Money;
import com.entity.PhiliaLove;
import com.entity.PitBull;
import com.entity.Yen;

public class MainApp {
	public static void main(String[] args) {
		/*LoveDAO loveDAO = new LoveDAO();
		loveDAO.create(new ChocolateLove("sweet"), new PhiliaLove("you are beauty!"), new Love("love all of you!"));*/
		
		/*MoneyDAO moneyDAO = new MoneyDAO();
		Money money3 = new Money("Default");
		Dollar money1 = new Dollar("$");
		Yen money2 = new Yen("picture");
		moneyDAO.create(money1, money2, money3);*/
		
		/*MoneyDAO moneyDAO = new MoneyDAO();
		Dollar money1 = new Dollar("$");
		money1.setCountry("USA");
		Yen money2 = new Yen("picture");
		money2.setCountry("Japan");
		moneyDAO.create2(money1, money2);*/
		
		/*DogDAO dogDAO = new DogDAO();
		PitBull dog1 = new PitBull("boo",10);
		HouseDog dog2 = new HouseDog("HaNoi");
		dogDAO.create(dog1, dog2);*/
		
		ForestDAO forestDAO = new ForestDAO();
		Forest forest = new Forest("bamboo");
		Bird bird = new Bird("long");
		forestDAO.create(forest, bird);
	}
}
