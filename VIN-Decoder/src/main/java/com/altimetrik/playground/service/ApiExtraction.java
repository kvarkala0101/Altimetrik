package com.altimetrik.playground.service;

import com.altimetrik.playground.model.Decoder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface ApiExtraction {

	public Decoder getVinDecoder(String vinMetaData) throws JsonMappingException, JsonProcessingException;
}
