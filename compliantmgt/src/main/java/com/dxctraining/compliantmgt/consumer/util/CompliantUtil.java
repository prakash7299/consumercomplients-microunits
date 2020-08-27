package com.dxctraining.compliantmgt.consumer.util;

import org.springframework.stereotype.Component;

import com.dxctraining.compliantmgt.consumer.dto.CompliantDto;
import com.dxctraining.compliantmgt.consumer.entities.Compliant;


@Component
public class CompliantUtil {
	
	public CompliantDto compliantDto(Compliant compliant,int consumerId,String name) {
		CompliantDto dto=new CompliantDto(compliant.getId(),compliant.getDescription());
		dto.setConsumerId(consumerId);
		dto.setName(name);
		return dto;
	}

}
