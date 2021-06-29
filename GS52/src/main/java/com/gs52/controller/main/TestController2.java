package com.gs52.controller.main;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController2 {
	@GetMapping("/all")
	public String allAccess() {
		System.out.println("all 권한 들어옴");
		return "Public Content.";
	}
	@GetMapping("/all2")
	public String allAccess22() {
		System.out.println("all22 권한 들어옴");
		return "Public Content22.";
	}
	@GetMapping("/user")
//	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PreAuthorize("hasRole('USER')")
	public String userAccess() {

		System.out.println("user call~");
		return "User Content.2";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
//	public String moderatorAccess(@RequestParam String username, @RequestHeader String headers) {
	public String moderatorAccess() {
		System.out.println("MODERATOR!!!");
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		System.out.println("admin !!!");
		return "Admin Board.";
	}
}
