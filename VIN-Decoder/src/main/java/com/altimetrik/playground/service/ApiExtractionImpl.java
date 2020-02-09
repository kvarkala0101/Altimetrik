package com.altimetrik.playground.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.playground.model.Decoder;
import com.altimetrik.playground.model.Results;
import com.altimetrik.playground.model.VinData;
import com.altimetrik.playground.util.JsonToObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class ApiExtractionImpl implements ApiExtraction {

	@Autowired
	JsonToObject jsonToObject;

	@Override
	public Decoder getVinDecoder(String vinMetaData) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		VinData vinData = jsonToObject.getObject(vinMetaData);
		
		return getVinDecoder(vinData);
	}

	private Decoder getVinDecoder(VinData vinData) {

		Decoder vinDecoder = new Decoder();
		Results[] results = vinData.getResults();
		for (Results result : results) {
			vinDecoder = filter(result, vinDecoder, result.getVariable());
		}

		return vinDecoder;

	}

	private Decoder filter(Results result, Decoder vinDecoder, String property) {
		switch (property) {

		case "Make":
			vinDecoder.setMake(result.getValue());
			break;
		case "Model":
			vinDecoder.setModel(result.getValue());
			break;
		case "Year":
			vinDecoder.setYear(result.getValue());
			break;
		case "Plant Country":
			vinDecoder.setPlantCountry(result.getValue());
			break;
		case "Plant State":
			vinDecoder.setPlantState(result.getValue());
			break;
		default:
			break;
		}

		return vinDecoder;
	}

}
