package com.dxctraining.consumermgt.consumer.util;

import org.springframework.stereotype.Component;

import com.dxctraining.consumermgt.consumer.dto.ConsumerDto;
import com.dxctraining.consumermgt.consumer.entities.Consumer;

@Component
public class ConsumerUtil {
	
	public ConsumerDto consumerDto(Consumer consumer,int compliantId,String description) {
		ConsumerDto dto=new ConsumerDto(consumer.getId(),consumer.getName());
		dto.setCompliantId(compliantId);
		dto.setDescription(description);
		return dto;
	}

}
