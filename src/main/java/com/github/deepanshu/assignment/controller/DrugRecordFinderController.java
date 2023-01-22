package com.github.deepanshu.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.deepanshu.assignment.service.ServiceLayer;

@RestController
public class DrugRecordFinderController {
	
	private final ServiceLayer serviceLayer;
	
	@Autowired
	public DrugRecordFinderController(ServiceLayer serviceLayer) {
		this.serviceLayer = serviceLayer;
	}
	
	@GetMapping("/api.fda.gov/drug/drugsfda.json")
	@CrossOrigin
	public String getData(@RequestParam(required = true) String manufacturerName,@RequestParam(required = false) String brandName) {
		return serviceLayer.fetchDrugRecordApplicationDetail(manufacturerName,brandName);
	}

}
