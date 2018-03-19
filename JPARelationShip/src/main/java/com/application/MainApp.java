package com.application;

import java.util.ArrayList;
import java.util.List;

import com.dao.ManagerDAO;
import com.dao.SchoolDAO;
import com.dao.ShopDAO;
import com.entity.Admin;
import com.entity.Chair;
import com.entity.SubAdmin;
import com.entity.Desk;
import com.entity.Employee;
import com.entity.Store;

public class MainApp {
	public static void main(String[] args) {
		/*ManagerDAO managerDAO = new ManagerDAO();
		Admin admin = new Admin("SP1");
		SubAdmin subAdmin = new SubAdmin("SP.2");
		managerDAO.createAdminAndSub(admin, subAdmin);*/
		
		/*SchoolDAO schoolDAO = new SchoolDAO();
		Chair chair1 = new Chair(10);
		Chair chair2 = new Chair(10);
		Chair chair3 = new Chair(10);
		schoolDAO.createTableAndChair(new Desk(100),chair1,chair2,chair3);*/
		
		ShopDAO  shopDAO = new ShopDAO();
		Store store1 = new Store("store1");
		Store store2 = new Store("store2");
		Employee employee1 = new Employee("employee1");
		Employee employee2 = new Employee("employee2");
		List<Store> stores = new ArrayList<Store>();
		stores.add(store1);
		stores.add(store2);
		shopDAO.createStoreAndEmployee(stores, employee1,employee2);
	}
}
