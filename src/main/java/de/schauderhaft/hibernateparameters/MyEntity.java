package de.schauderhaft.hibernateparameters;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyEntity {


	private String id;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
