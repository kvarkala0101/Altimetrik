package com.altimetrik.playground.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.altimetrik.playground.model.VinData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonToObject {

	@Autowired
	ObjectMapper objectMapper;
	
	public VinData getObject(String json) throws JsonMappingException, JsonProcessingException {
		return objectMapper.readValue(json, VinData.class);
	}
}
