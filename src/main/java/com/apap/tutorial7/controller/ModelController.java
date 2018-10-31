package com.apap.tutorial7.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.rest.Setting;

@RestController
@RequestMapping("/model")
public class ModelController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@GetMapping()
	private ResponseEntity<String> getModels(@RequestParam("factory") String factory) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		String path = Setting.carQueryUrl + "?cmd=getModels&make=" + factory + "&year=" + year;
		ResponseEntity<String> res = restTemplate.exchange(path, HttpMethod.GET, entity, String.class);
		System.out.println(path);
		return res;
	}
	
}