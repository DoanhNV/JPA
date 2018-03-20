package com.application;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.config.ApplicationConfig;
import com.dao.RoomDAO;
import com.entity.Room;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoomDAO roomDAO = context.getBean(RoomDAO.class);
		Room room = new Room("Room 4", 9);
		roomDAO.create(room);
		((AbstractApplicationContext) context).close();
	}
}
