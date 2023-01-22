package com.github.deepanshu.assignment.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	
	@JsonProperty("openfda")
	private OpenFDADetail openfdaDetail;

	public OpenFDADetail getOpenfdaDetail() {
		return openfdaDetail;
	}
	
	@JsonProperty("products")
	private List<Product> productList;
	
	
	public Result() {
		super();
	}

	public Result(OpenFDADetail openfdaDetail, List<Product> productList) {
		super();
		this.openfdaDetail = openfdaDetail;
		this.productList = productList;
	}

	public List<Product> getProductList() {
		return productList;
	}
	
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public void setOpenfdaDetail(OpenFDADetail openfdaDetail) {
		this.openfdaDetail = openfdaDetail;
	}
}
