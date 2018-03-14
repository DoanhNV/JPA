package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fighter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name = "war_number")
	private int warNumber;

	public Fighter() {

	}
	
	public Fighter(String name, int warNumber) {
		this.name = name;
		this.warNumber = warNumber;
	}

	public Fighter(int id, String name, int warNumber) {
		this.id = id;
		this.name = name;
		this.warNumber = warNumber;
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

	public int getWarNumber() {
		return warNumber;
	}

	public void setWarNumber(int warNumber) {
		this.warNumber = warNumber;
	}

	@Override
	public String toString() {
		return "Fighter [id=" + id + ", name=" + name + ", warNumber=" + warNumber + "]";
	}
	
}
