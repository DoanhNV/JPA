package com.entity;
/*@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)*/
public class Money {
	
	protected int id;
	protected String country;
	
	public Money() {

	}

	public Money(String country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
