package com.dxctraining.compliantmgt.consumer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "compliants")
public class Compliant {
	@Id
	@GeneratedValue
	private int id;
	private String description;
	private int consumerId;

	public Compliant() {

	}


	public Compliant(String description,int id) {
		this.description = description;
		this.id=id;
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


	public int getConsumerId() {
		return consumerId;
	}


	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
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
