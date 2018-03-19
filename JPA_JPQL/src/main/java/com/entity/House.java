package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/*@Entity(name = "house")*/
@Entity
@NamedQuery(query = "select h from house h where h.id = :id", name = "find by id")
public class House {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int room;
	
	public House() {

	}
	
	public House(String name, int room) {
		this.name = name;
		this.room = room;
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

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", name=" + name + ", room=" + room + "]";
	}
	
}
