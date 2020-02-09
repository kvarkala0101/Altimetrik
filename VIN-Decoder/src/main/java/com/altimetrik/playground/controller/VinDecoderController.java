package com.altimetrik.playground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.altimetrik.playground.model.Decoder;
import com.altimetrik.playground.service.ApiExtraction;

@RestController
public class VinDecoderController {

	@Value("${vin.data.url}")
	private String api;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ApiExtraction apiExtraction;

	@GetMapping("/")
	public ModelAndView homePage(Model model) {
		return new ModelAndView("welcome");
	}

	@GetMapping("/getDetails/{vin}")
	@ResponseBody
	public ResponseEntity<Decoder> getDetails(@PathVariable("vin") String vinNumber, Model model) {

		Decoder vinData = null;
		if (vinNumber.length() == 17) {
			String vinapi = api + vinNumber + "?format=json";

			ResponseEntity<String> response = restTemplate.getForEntity(vinapi, String.class);
			HttpStatus statusCode = response.getStatusCode();

			if (statusCode.toString().equals("200 OK")) {
				try {
					vinData = apiExtraction.getVinDecoder(response.getBody());
					return new ResponseEntity<Decoder>(vinData, HttpStatus.CREATED);
				} catch (Exception e) {
					return new ResponseEntity<Decoder>(vinData, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				return new ResponseEntity<Decoder>(vinData, HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<Decoder>(vinData, HttpStatus.BAD_REQUEST);
		}
	}
}
