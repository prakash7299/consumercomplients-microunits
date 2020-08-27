package com.dxctraining.compliantmgt.consumer.controller;

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
import org.springframework.web.client.RestTemplate;

import com.dxctraining.compliantmgt.consumer.dto.CompliantDto;
import com.dxctraining.compliantmgt.consumer.dto.ConsumerDto;
import com.dxctraining.compliantmgt.consumer.dto.CreateCompliantRequest;
import com.dxctraining.compliantmgt.consumer.dto.UpdateCompliantRequest;
import com.dxctraining.compliantmgt.consumer.entities.Compliant;
import com.dxctraining.compliantmgt.consumer.service.ICompliantService;
import com.dxctraining.compliantmgt.consumer.util.CompliantUtil;


@RestController
@RequestMapping("/consumers")
public class CompliantRestController {
	
	@Autowired
	private ICompliantService service;
	
	@Autowired
	private CompliantUtil compliantUtil;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
	public CompliantDto create(@RequestBody CreateCompliantRequest data) {
		Compliant compliant=new Compliant(data.getDescription(),data.getConsumerId());
		compliant=service.add(compliant);
		ConsumerDto consumer=fetchFromConsumerAppById(data.getConsumerId());
		CompliantDto response =compliantUtil.compliantDto(compliant,consumer.getId(),consumer.getName());
		return response;
	}
	
	@GetMapping("/get/{id}")
	public CompliantDto findCompliant(@PathVariable("id") int id) {
		Compliant compliant=service.findCompliantById(id);
		ConsumerDto consumer=fetchFromConsumerAppById(compliant.getConsumerId());
		CompliantDto dto =compliantUtil.compliantDto(compliant,consumer.getId(),consumer.getName());
	      return dto;
	}
	@PutMapping("/update")
	public CompliantDto updateCompliant(@RequestBody UpdateCompliantRequest data) {
		int id=data.getId();
		String description=data.getDescription();
		Compliant compliant=service.findCompliantById(id);
		compliant.setId(id);
		compliant.setDescription(description);
		compliant=service.update(compliant);
		ConsumerDto consumer=fetchFromConsumerAppById(compliant.getConsumerId());
		 CompliantDto dto =compliantUtil.compliantDto(compliant, consumer.getId(), consumer.getName());
	      return dto;
	}
	public ConsumerDto fetchFromConsumerAppById(int consumerId) {
        String url = "http://localhost:8585/consumers/get/" + consumerId;
        ConsumerDto dto = restTemplate.getForObject(url, ConsumerDto.class);
        return dto;
    }

	
}
