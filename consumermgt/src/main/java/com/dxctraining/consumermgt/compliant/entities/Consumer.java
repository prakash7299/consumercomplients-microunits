package com.dxctraining.consumermgt.compliant.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "compliants")
public class Consumer {
	@Id
	@GeneratedValue
	private int id;
	private String name;

	public Consumer() {

	}


	public Consumer(String description) {
		this.name = description;
	}

	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getDescription() {
		return name;
	}


	public void setDescription(String description) {
		this.name = description;
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
		Consumer that = (Consumer) o;
		return id == that.id;

	}

}
