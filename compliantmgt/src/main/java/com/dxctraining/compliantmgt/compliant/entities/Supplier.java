package com.dxctraining.inventorymgt.supplier.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "suppliers_information")
public class Supplier {
	@Id
	@GeneratedValue
	private int id;
	private String sname;
	private String password;

	public Supplier() {

	}


	public Supplier(String sname, String password) {
		this.sname = sname;
		this.password = password;
	}

	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return sname;
	}

	public void setName(String sname) {
		this.sname = sname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		Supplier that = (Supplier) o;
		return id == that.id;

	}

}
