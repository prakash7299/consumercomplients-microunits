package com.dxctraining.compliantmgt.consumer.dto;

public class CompliantDto {
	private int id;
	private String name;
	
	private int consumerId;
	private String description;
	
	
	public int getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CompliantDto() {
		
	}
	public CompliantDto(int id,String description) {
		this.id=id;
		this.name=description;
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