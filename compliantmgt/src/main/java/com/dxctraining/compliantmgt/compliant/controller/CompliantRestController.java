package com.dxctraining.compliantmgt.compliant.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.dxctraining.compliantmgt.compliant.dto.CompliantDto;
import com.dxctraining.compliantmgt.compliant.dto.ConsumerDto;
import com.dxctraining.compliantmgt.compliant.dto.CreateCompliantRequest;
import com.dxctraining.compliantmgt.compliant.dto.UpdateCompliantRequest;
import com.dxctraining.compliantmgt.compliant.entities.Compliant;
import com.dxctraining.compliantmgt.compliant.service.ICompliantService;
import com.dxctraining.compliantmgt.compliant.util.CompliantUtil;



@RestController
@RequestMapping("/compliants")
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
	
	
	@GetMapping
	public List<CompliantDto> fetchAll(){
		List<Compliant> list=service.allCompliants();
		List<CompliantDto> response=new ArrayList<>();
		for(Compliant compliant:list) {
			int consumerId=compliant.getConsumerId();
			ConsumerDto consumer=fetchFromConsumerAppById(consumerId);
			CompliantDto compliantDto=compliantUtil.compliantDto(compliant, consumerId,consumer.getName());
			response.add(compliantDto);
		}
		return response;
		
		
	}
	@GetMapping("/consumers/{consumerId}")
	public List<CompliantDto> fetchAllCompliantsById(@PathVariable("consumerId")int consumerId){
		List<Compliant> list = service.allCompliantsByConsumer(consumerId);
        List<CompliantDto>response=new ArrayList<>();
        ConsumerDto consumer= fetchFromConsumerAppById(consumerId);
        for (Compliant compliant:list){
            CompliantDto dto=compliantUtil.compliantDto(compliant,consumer.getId(),consumer.getName());
            response.add(dto);
        }
        return response;
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
