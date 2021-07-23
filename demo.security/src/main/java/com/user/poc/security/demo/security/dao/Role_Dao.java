package com.user.poc.security.demo.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.poc.security.demo.security.entity.Role;

@Repository
public interface Role_Dao extends JpaRepository<Role, Integer> {
	
	

}
