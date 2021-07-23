package com.user.poc.security.demo.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Authorised_Controller {

	@GetMapping("/authorised")
	public String msg() {
		return "This is Authorised page";
	}
}
