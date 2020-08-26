package com.dxctraining.compliantmgt.compliant.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "compliants")
public class Compliant {
	@Id
	@GeneratedValue
	private int id;
	private String description;

	public Compliant() {

	}


	public Compliant(String description) {
		this.description = description;
	}

	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Compliant that = (Compliant) o;
		return id == that.id;

	}

}
