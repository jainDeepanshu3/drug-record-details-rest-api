package com.github.deepanshu.assignment.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaDetail {

	private String disclaimer;
	private String terms;
	private String license;
	
	@JsonProperty("lastUpdated")
	private String lastUpdated;
	
	@JsonProperty("results")
	private MetaResult metaResult;

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public MetaResult getMetaResult() {
		return metaResult;
	}

	public void setMetaResult(MetaResult metaResult) {
		this.metaResult = metaResult;
	}
}
