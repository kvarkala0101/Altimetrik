package com.altimetrik.playground.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.altimetrik.playground.model.Decoder;
import com.altimetrik.playground.model.Results;
import com.altimetrik.playground.model.VinData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class ApiExtractionImplTest {

	@InjectMocks
	private ApiExtraction apiExtraction = new ApiExtractionImpl();

	@Mock
	private ObjectMapper objectMapper;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testfilter() {

		try {
			Decoder decoder = apiExtraction.getVinDecoder(getJson(getVinData()));
			assertEquals("BMW", decoder.getMake());
			assertEquals("Plant State", decoder.getPlantState());

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	public VinData getVinData() {

		VinData vinData = new VinData();
		vinData.setCount("17");
		vinData.setMessage("Hello Wold");
		vinData.setSearchCriteria("binarySearch");

		Results[] result = new Results[2];
		Results result1 = new Results();
		result1.setValue("BMW");
		result1.setValueId("11");
		result1.setVariable("Make");
		result1.setVariableId("11");

		Results result2 = new Results();
		result1.setValue("Michigan");
		result1.setValueId("11");
		result1.setVariable("Plant State");
		result1.setVariableId("11");

		result[0] = result1;
		result[1] = result2;

		vinData.setResults(result);

		return vinData;
	}

	public String getJson(VinData vinData) throws JsonProcessingException {
		return objectMapper.writeValueAsString(vinData);
	}

}
