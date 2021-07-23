package com.user.poc.security.demo.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.poc.security.demo.security.dto.Login_dto;
import com.user.poc.security.demo.security.service.Registration_ServiceImpl;

@RestController
public class Login_Controller {

	@Autowired
	private Registration_ServiceImpl registration_ServiceImpl;
	
	@PostMapping("/login")
	public String doLogin(@RequestBody Login_dto login) {
		
		if(registration_ServiceImpl.doLogin(login)) {
			return "Login Success";
		}
		
		return "Login Failed";
	}
}
