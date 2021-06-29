package com.gs52.controller.main;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/main/test")
public class HiController {
	
	@GetMapping("/hi")
	public String allAccess() {
		System.out.println("22222 all 권한 들어옴");
		return "Public Content.";
	}
	@GetMapping("/hi2")
	public String allAccess22() {
		System.out.println("all22 권한 들어옴");
		return "Public Content22.";
	}

}
