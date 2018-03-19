package com.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id" )
public class HouseDog extends Dog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address;
	
	public HouseDog() {

	}

	public HouseDog(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
