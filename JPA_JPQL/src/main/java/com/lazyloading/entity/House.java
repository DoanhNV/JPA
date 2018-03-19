package com.lazyloading.entity;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;

@Entity(name = "house")
@NamedQuery(query = "select h from house h where h.id = :id", name = "find house by id")
public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Basic(fetch = FetchType.LAZY) // only work with byte or char field
	@Lob
	private String name;
	private int room;
	@Basic(fetch = FetchType.LAZY)
	@Lob
	private Byte[] picture;

	public House() {

	}

	public House(String name, int room, Byte[] picture) {
		this.name = name;
		this.room = room;
		this.picture = picture;
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

	public Byte[] getPicture() {
		return picture;
	}

	public void setPicture(Byte[] picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", name=" + name + ", room=" + room + ", picture=" + Arrays.toString(picture) + "]";
	}

}
