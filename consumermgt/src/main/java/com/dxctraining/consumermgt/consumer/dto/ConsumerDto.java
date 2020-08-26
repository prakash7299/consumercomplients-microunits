package com.dxctraining.consumermgt.consumer.dto;

public class ConsumerDto {
	private int id;
	private String name;
	
	private int compliantId;
	private String description;
	
	
	public int getCompliantId() {
		return compliantId;
	}
	public void setCompliantId(int compliantId) {
		this.compliantId = compliantId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ConsumerDto() {
		
	}
	public ConsumerDto(int id,String name) {
		this.id=id;
		this.name=name;
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
	
	
	
}