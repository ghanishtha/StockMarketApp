package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.CompanyCode;
import com.example.demo.repository.CompanyCodeRepository;

public class CompanyCodeService {

	@Autowired
	CompanyCodeRepository repository;
	
	
	public CompanyCode findByCompanyCode(int code) {
		// TODO Auto-generated method stub
		return repository.findByCode(code);
	}

}
