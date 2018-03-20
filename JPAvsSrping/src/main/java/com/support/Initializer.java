package com.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.constant.Constant;

public class Initializer {
	
	public static void createDataBaseIfNotExist() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Constant.DB_NAME, "root", "");
			Statement stmt = connection.createStatement();
			stmt.executeQuery("CREATE DATABASE IF NOT EXISTS " + Constant.DB_NAME);
		} catch (SQLException e) {
		}
	}
}
