package com.github.deepanshu.assignment.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenFDABrandName {
	

	@JsonProperty("brand_name")
	private String brandName;

	public OpenFDABrandName(String brandName) {
		super();
		this.brandName = brandName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}
