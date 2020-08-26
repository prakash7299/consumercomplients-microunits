package com.dxctraining.consumermgt.consumer.dto;

public class CreateConsumerRequest {
	private String name;
	private int compliantId;
	

	public int getCompliantId() {
		return compliantId;
	}

	public void setCompliantId(int compliantId) {
		this.compliantId = compliantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
