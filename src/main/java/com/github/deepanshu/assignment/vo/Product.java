package com.github.deepanshu.assignment.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
	
	@JsonProperty("brand_name")
	private String productName;

	public Product() {
		super();
	}

	public Product(String productName) {
		super();
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
