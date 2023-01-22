package com.github.deepanshu.assignment.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DrugDetail {
	
	@JsonProperty("meta")
	private MetaDetail metaDetail;

	@JsonProperty("results")
	private List<Result> resultList;

	public List<Result> getResultList() {
		return resultList;
	}

	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DrugDetail [resultList=").append(resultList).append("]");
		return builder.toString();
	}
}
