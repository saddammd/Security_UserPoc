package com.user.poc.security.demo.security.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.poc.security.demo.security.dao.User_Dao;
import com.user.poc.security.demo.security.dto.Login_dto;
import com.user.poc.security.demo.security.entity.Role;
import com.user.poc.security.demo.security.entity.User;

@Service
public class Registration_ServiceImpl implements Registration_Service {

	@Autowired
	private User_Dao user_Dao;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	public User doRegister(User user) {
		
		Role role = new Role();
		role.setRole_title("User");
		Set<Role> role_set = new HashSet<>();
		role_set.add(role);
		user.setRole(role_set);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return user_Dao.save(user);
		}

	@Override
	public boolean doLogin(Login_dto login) {
		/*
		 * if(user_Dao.findByEmailAndPassword(login.getEmail(),
		 * login.getPassword())!=null) { return true; } else return false;
		 */
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(login.getEmail());
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, login.getPassword(), userDetails.getAuthorities());
		authenticationManager.authenticate(token);
				
		boolean authenticated = token.isAuthenticated();
		
		if(authenticated) {
			
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		
		return authenticated;
		}

	@Override
	public User findByEmail(String email) {
		
		if(user_Dao.findByEmail(email)!=null) {
			return user_Dao.findByEmail(email);
		}
		
		else return null;
	}

	
}
