package com.user.poc.security.demo.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome_Controller {

	@GetMapping("/home")
	public String msg() {
		return "This is Welcome page";
	}
}
