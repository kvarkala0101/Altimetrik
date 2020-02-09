package com.altimetrik.playground.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VinData {

	@JsonProperty("Count")
	private String count;
	
	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("SearchCriteria")
	private String searchCriteria;
	
	@JsonProperty("Results")
	private Results[] results;
	
	public VinData() {
	
	}
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSearchCriteria() {
		return searchCriteria;
	}
	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	public Results[] getResults() {
		return results;
	}
	public void setResults(Results[] results) {
		this.results = results;
	}
	
	
}
