package com.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id" )
public class PitBull extends Dog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int teethNumber;

	public PitBull() {

	}

	public PitBull(String name, int teethNumber) {
		this.name = name;
		this.teethNumber = teethNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeethNumber() {
		return teethNumber;
	}

	public void setTeethNumber(int teethNumber) {
		this.teethNumber = teethNumber;
	}

}
