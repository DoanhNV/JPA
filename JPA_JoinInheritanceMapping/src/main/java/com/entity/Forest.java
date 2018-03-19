package com.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Forest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(targetEntity = Bird.class)
	@JoinColumn(name = "bird_id", referencedColumnName = "id")
	private Bird birds;
	private String name;

	public Forest() {

	}

	public Forest(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bird getBirds() {
		return birds;
	}

	public void setBirds(Bird birds) {
		this.birds = birds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
