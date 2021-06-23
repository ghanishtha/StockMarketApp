package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public User findById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public User saveUser(User user) {
		return repository.save(user);
	}

	public boolean isEmailUnique(String email) {
		// TODO Auto-generated method stub
		User user = repository.findByEmail(email);
		if(user!=null) return false;
		else return true;
	}

	public boolean isUserNameUnique(String username) {
		// TODO Auto-generated method stub
		User user = repository.findByUsername(username);
		if(user!=null) return false;
		else return true;
	}

	public boolean isMobileUnique(Long mobileNumber) {
		// TODO Auto-generated method stub
		User user = repository.findByMobileNumber(mobileNumber);
		if(user!=null) return false;
		else return true;
	}

}
