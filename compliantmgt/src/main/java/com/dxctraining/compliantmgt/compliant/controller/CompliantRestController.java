package com.dxctraining.compliantmgt.compliant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dxctraining.compliantmgt.compliant.dto.CompliantDto;
import com.dxctraining.compliantmgt.compliant.dto.CreateCompliantRequest;
import com.dxctraining.compliantmgt.compliant.dto.UpdateCompliantRequest;
import com.dxctraining.compliantmgt.compliant.entities.Compliant;
import com.dxctraining.compliantmgt.compliant.service.ICompliantService;

@RestController
@RequestMapping("/compliants")
public class CompliantRestController {
	
	@Autowired
	private ICompliantService service;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
	public CompliantDto create(@RequestBody CreateCompliantRequest Data) {
		Compliant compliant=new Compliant(Data.getDescription());
		compliant=service.add(compliant);
		CompliantDto response = toDto(compliant);
		return response;
	}
	public CompliantDto toDto(Compliant compliant) {
        CompliantDto dto = new CompliantDto();
        dto.setId(compliant.getId());
        dto.setDescription(compliant.getDescription());
        return dto;
    }
	@GetMapping("/get/{id}")
	public CompliantDto findCompliant(@PathVariable("id") int id) {
		Compliant compliant=service.findCompliantById(id);
		 CompliantDto dto =toDto(compliant);
	      return dto;
	}
	@PutMapping("/update")
	public CompliantDto updateCompliant(@RequestBody UpdateCompliantRequest data) {
		Compliant compliant=new Compliant();
		compliant.setId(data.getId());
		compliant.setDescription(data.getDescription());
		compliant=service.update(compliant);
		 CompliantDto dto =toDto(compliant);
	      return dto;
	}
	
	

}
