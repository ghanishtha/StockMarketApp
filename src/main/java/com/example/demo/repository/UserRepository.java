package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	User findByUsername(String username);
	User findByMobileNumber(Long mobileNumber);

}
