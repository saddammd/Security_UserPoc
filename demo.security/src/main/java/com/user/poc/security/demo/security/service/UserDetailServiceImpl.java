package com.user.poc.security.demo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.poc.security.demo.security.dao.User_Dao;
import com.user.poc.security.demo.security.entity.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	User_Dao user_Dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(user_Dao.findByEmail(username)!=null) {
			
			User user = user_Dao.findByEmail(username);
						
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRole());
		}
		
		return null;
	}

	

}
