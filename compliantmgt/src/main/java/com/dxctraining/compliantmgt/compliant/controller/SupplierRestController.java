package com.dxctraining.inventorymgt.supplier.controller;

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
import com.dxctraining.inventorymgt.supplier.dto.CreateSupplierRequest;
import com.dxctraining.inventorymgt.supplier.dto.UpdateSupplierRequest;
import com.dxctraining.inventorymgt.supplier.dto.SupplierDto;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierRestController {
	
	@Autowired
	private ISupplierService service;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
	public SupplierDto create(@RequestBody CreateSupplierRequest supplierData) {
		Supplier supplier=new Supplier(supplierData.getName(),supplierData.getPassword());
		supplier=service.add(supplier);
		SupplierDto response = toDto(supplier);
		return response;
	}
	
	@GetMapping("/get/{id}")
	public SupplierDto findSupplier(@PathVariable("id") int id) {
		Supplier supplier=service.findSupplierById(id);
		 SupplierDto dto =toDto(supplier);
	      return dto;
	}
	@PutMapping("/update")
	public SupplierDto updateSupplier(@RequestBody UpdateSupplierRequest supplierData) {
		Supplier supplier=new Supplier(supplierData.getName(),supplierData.getPassword());
		supplier.setId(supplierData.getId());
		supplier=service.add(supplier);
		 SupplierDto dto =toDto(supplier);
	      return dto;
	}
	public SupplierDto toDto(Supplier supplier) {
        SupplierDto dto = new SupplierDto();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setPassword(supplier.getPassword());
        return dto;
    }
	

}
