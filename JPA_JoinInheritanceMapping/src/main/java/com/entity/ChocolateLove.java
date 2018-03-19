package com.entity;

import javax.persistence.Entity;

@Entity
/*@DiscriminatorColumn(name = "chocolateType")*/
public class ChocolateLove extends Love {
	
	private String smell;
	
	public ChocolateLove() {

	}

	public ChocolateLove(String smell) {
		this.smell = smell;
	}

	public String getSmell() {
		return smell;
	}

	public void setSmell(String smell) {
		this.smell = smell;
	}
	
}
