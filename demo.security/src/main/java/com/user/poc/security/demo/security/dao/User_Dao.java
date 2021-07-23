package com.user.poc.security.demo.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.poc.security.demo.security.entity.User;

@Repository
public interface User_Dao extends JpaRepository<User, Integer> {

	public User findByEmailAndPassword(String username, String password);
	public User findByEmail(String username);
	
	
	
	

}
