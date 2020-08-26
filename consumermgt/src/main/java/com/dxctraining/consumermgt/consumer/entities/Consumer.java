package com.dxctraining.consumermgt.consumer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "consumers")
public class Consumer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int compliantId;

	public Consumer() {

	}


	public Consumer(String name,int compliantId ) {
		this.name = name;
		this.compliantId=compliantId;
	}

	
	

	public int getCompliantId() {
		return compliantId;
	}


	public void setCompliantId(int compliantId) {
		this.compliantId = compliantId;
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
