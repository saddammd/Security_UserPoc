package com.user.poc.security.demo.security.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.poc.security.demo.security.dto.Registration_dto;
import com.user.poc.security.demo.security.entity.User;
import com.user.poc.security.demo.security.service.Registration_ServiceImpl;

@RestController
public class Register_Controller {
	
	@Autowired
	private Registration_ServiceImpl registration_ServiceImpl;

	@PostMapping("/register")
	public String register(@RequestBody Registration_dto reg) {
		
		User user = new User();
		BeanUtils.copyProperties(reg, user);
		registration_ServiceImpl.doRegister(user);		
		return "User Regsitered SuccessFully" +registration_ServiceImpl.findByEmail(user.getEmail());
		
	}
}
