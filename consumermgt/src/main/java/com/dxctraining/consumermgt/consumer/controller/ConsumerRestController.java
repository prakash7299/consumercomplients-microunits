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
import com.dxctraining.consumermgt.consumer.dto.ConsumerDto;
import com.dxctraining.consumermgt.consumer.dto.CreateConsumerRequest;
import com.dxctraining.consumermgt.consumer.dto.UpdateConsumerRequest;
import com.dxctraining.consumermgt.consumer.entities.Consumer;
import com.dxctraining.consumermgt.consumer.service.IConsumerService;

@RestController
@RequestMapping("/consumers")
public class ConsumerRestController {
	
	@Autowired
	private IConsumerService service;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
	public ConsumerDto create(@RequestBody CreateConsumerRequest Data) {
		Consumer consumer=new Consumer(Data.getName());
		consumer=service.add(consumer);
		ConsumerDto response = toDto(consumer);
		return response;
	}
	
	public ConsumerDto toDto(Consumer consumer) {
        ConsumerDto dto = new ConsumerDto();
        dto.setId(consumer.getId());
        dto.setName(consumer.getName());
        return dto;
    }
	@GetMapping("/get/{id}")
	public ConsumerDto findConsumer(@PathVariable("id") int id) {
		Consumer consumer=service.findConsumerById(id);
		 ConsumerDto dto =toDto(consumer);
	      return dto;
	}
	@PutMapping("/update")
	public ConsumerDto updateConsumer(@RequestBody UpdateConsumerRequest data) {
		Consumer consumer=new Consumer();
		consumer.setId(data.getId());
		consumer.setName(data.getName());
		consumer=service.update(consumer);
		 ConsumerDto dto =toDto(consumer);
	      return dto;
	}
	
}
