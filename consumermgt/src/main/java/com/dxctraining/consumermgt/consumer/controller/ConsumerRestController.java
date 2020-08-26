package com.dxctraining.consumermgt.consumer.controller;

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
import com.dxctraining.consumermgt.consumer.dto.CompliantDto;
import com.dxctraining.consumermgt.consumer.dto.ConsumerDto;
import com.dxctraining.consumermgt.consumer.dto.CreateConsumerRequest;
import com.dxctraining.consumermgt.consumer.dto.UpdateConsumerRequest;
import com.dxctraining.consumermgt.consumer.entities.Consumer;
import com.dxctraining.consumermgt.consumer.service.IConsumerService;
import com.dxctraining.consumermgt.consumer.util.ConsumerUtil;

@RestController
@RequestMapping("/consumers")
public class ConsumerRestController {
	
	@Autowired
	private IConsumerService service;
	
	@Autowired
	private ConsumerUtil consumerUtil;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
	public ConsumerDto create(@RequestBody CreateConsumerRequest data) {
		Consumer consumer=new Consumer(data.getName(),data.getCompliantId());
		consumer=service.add(consumer);
		CompliantDto compliant=fetchFromCompliantAppById(data.getCompliantId());
		ConsumerDto response =consumerUtil.consumerDto(consumer,compliant.getId(),compliant.getDescription());
		return response;
	}
	
	@GetMapping("/get/{id}")
	public ConsumerDto findConsumer(@PathVariable("id") int id) {
		Consumer consumer=service.findConsumerById(id);
		CompliantDto compliant=fetchFromCompliantAppById(consumer.getCompliantId());
		ConsumerDto dto =consumerUtil.consumerDto(consumer,consumer.getCompliantId(),compliant.getDescription());
	      return dto;
	}
	@PutMapping("/update")
	public ConsumerDto updateConsumer(@RequestBody UpdateConsumerRequest data) {
		int id=data.getId();
		String name=data.getName();
		Consumer consumer=service.findConsumerById(id);
		consumer.setId(id);
		consumer.setName(name);
		consumer=service.update(consumer);
		CompliantDto compliant=fetchFromCompliantAppById(consumer.getCompliantId());
		 ConsumerDto dto =consumerUtil.consumerDto(consumer, compliant.getId(), compliant.getDescription());
	      return dto;
	}
	public CompliantDto fetchFromCompliantAppById(int compliantId) {
        String url = "http://localhost:8586/compliants/get/" + compliantId;
        CompliantDto dto = restTemplate.getForObject(url, CompliantDto.class);
        return dto;
    }

	
}
