package com.github.deepanshu.assignment.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ManufacturerName {
	
	@JsonProperty("manufacturer_name")
	private String manufacturerName;
	
	public ManufacturerName(String manufacturerName) {
		super();
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
}
