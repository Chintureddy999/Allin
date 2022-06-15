package com.zensar.displayservice.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.displayservice.service.impl.DisplayServiceImpl;

@RestController
public class DisplayRestController {
	
	@Autowired
	private DisplayServiceImpl service;
	
	@Value("${company}") // This value is fetched from git repository using config server
	private String company;
	
	@GetMapping("/api/display")
	public String printMessage() 
	{
		return this.service.printMessage() + " From " + company;
	}
	
}