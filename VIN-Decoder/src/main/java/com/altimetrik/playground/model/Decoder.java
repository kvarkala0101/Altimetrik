package com.altimetrik.playground.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Decoder {

	@JsonProperty("Make")
	private String make;
	
	@JsonProperty("Model")
	private String model;
	
	@JsonProperty("Year")
	private String year;
	
	@JsonProperty("PlantCountry")
	private String plantCountry;
	
	@JsonProperty("PlantState")
	private String plantState;
	
	
	public Decoder() {
		
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getPlantCountry() {
		return plantCountry;
	}


	public void setPlantCountry(String plantCountry) {
		this.plantCountry = plantCountry;
	}


	public String getPlantState() {
		return plantState;
	}


	public void setPlantState(String plantState) {
		this.plantState = plantState;
	}
	
	
}
