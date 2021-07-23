package com.user.poc.security.demo.security.service;

import com.user.poc.security.demo.security.dto.Login_dto;
import com.user.poc.security.demo.security.entity.User;

public interface Registration_Service {

	public User doRegister(User user);
	public boolean doLogin(Login_dto login);
	public User findByEmail(String email);
}
