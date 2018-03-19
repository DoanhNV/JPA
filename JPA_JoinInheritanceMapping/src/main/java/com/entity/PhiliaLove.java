package com.entity;

import javax.persistence.Entity;

@Entity
public class PhiliaLove extends Love {
	
	private String mind;
	
	public PhiliaLove() {

	}

	public PhiliaLove(String mind) {
		this.mind = mind;
	}

	public String getMind() {
		return mind;
	}

	public void setMind(String mind) {
		this.mind = mind;
	}
	
}
