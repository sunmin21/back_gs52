package com.gs52.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class HomeController {
  
	
	@GetMapping(value="/a")
	public String home() {
		
		return "asdf";
	}
}


