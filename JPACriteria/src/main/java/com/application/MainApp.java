package com.application;

import java.util.List;

import com.dao.DepartmentDAO;
import com.dao.UserDAO;
import com.entity.Department;
import com.entity.User;

public class MainApp {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		Department department = new Department("developer");
		departmentDAO.create(department);
		User user = new User("DoanhNV", "doanhngo@gmail.com", "123456",department);
		userDAO.create(user);

		// UPDATE
		/*user.setId(1);
		User updateUser = new User("DoanhNgoVan", "ngovandoanhbg@gmail.com", "admin123",department);
		userDAO.update(user, updateUser);
*/
		// FIND BY ID
		User selectUser = userDAO.findById(1);
		System.out.println("========================================================================");
		System.out.println(selectUser);

		// LIST ALL
		List<User> users = userDAO.listAll();
		System.out.println("========================================================================");
		for (User user2 : users) {
			System.out.println(user2);
		}
		
		// LIST ALL AND ORDER
		System.out.println("========================================================================");
		List<User> listUser = userDAO.listAndOrder("desc");
		for (User user2 : listUser) {
			System.out.println(user2);
		}

		// DELETE
		userDAO.delete(2); 
		
		// JOIN 
		Object object = userDAO.getAndJoin(1);
		System.out.println(object);
	}
}
