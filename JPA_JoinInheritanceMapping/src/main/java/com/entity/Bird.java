package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bird {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String wing;
	@ManyToOne(targetEntity = Forest.class)
	@JoinColumn(name = "forest_id", referencedColumnName = "id")
	private Forest forest;

	public Bird() {

	}

	public Bird(String wing) {
		this.wing = wing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWing() {
		return wing;
	}

	public void setWing(String wing) {
		this.wing = wing;
	}

	public Forest getForest() {
		return forest;
	}

	public void setForest(Forest forest) {
		this.forest = forest;
	}
	

}
