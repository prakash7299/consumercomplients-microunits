package com.dxctraining.compliantmgt.compliant.util;

import org.springframework.stereotype.Component;

import com.dxctraining.compliantmgt.compliant.dto.CompliantDto;
import com.dxctraining.compliantmgt.compliant.entities.Compliant;




@Component
public class CompliantUtil {
	
	public CompliantDto compliantDto(Compliant compliant,int consumerId,String name) {
		CompliantDto dto=new CompliantDto(compliant.getId(),compliant.getDescription());
		dto.setConsumerId(consumerId);
		dto.setName(name);
		return dto;
	}

}
