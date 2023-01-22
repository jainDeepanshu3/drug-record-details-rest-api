package com.github.deepanshu.assignment.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenFDADetail {
	
	@JsonProperty("brand_name")
	private List<OpenFDABrandName> openfdaBrandNameList;
	
	@JsonProperty("manufacturer_name")
	private List<ManufacturerName> manufacturerNameList;
	
	public List<OpenFDABrandName> getOpenfdaBrandNameList() {
		return openfdaBrandNameList;
	}

	public void setOpenfdaBrandNameList(List<OpenFDABrandName> openfdaBrandNameList) {
		this.openfdaBrandNameList = openfdaBrandNameList;
	}

	public List<ManufacturerName> getManufacturerNameList() {
		return manufacturerNameList;
	}

	public void setManufacturerNameList(List<ManufacturerName> manufacturerNameList) {
		this.manufacturerNameList = manufacturerNameList;
	}

}
