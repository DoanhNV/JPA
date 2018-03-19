package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubAdmin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	private Admin manager;
	
	public SubAdmin() {

	}
	
	public SubAdmin(String name) {
		super();
		this.name = name;
	}

	public SubAdmin(String name, Admin manager) {
		this.name = name;
		this.manager = manager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Admin getManager() {
		return manager;
	}

	public void setManager(Admin manager) {
		this.manager = manager;
	}

}
