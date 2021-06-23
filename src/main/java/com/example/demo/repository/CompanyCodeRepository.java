package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CompanyCode;

public interface CompanyCodeRepository extends JpaRepository<CompanyCode, Integer>{

	CompanyCode findByCode(int companyCode);

}
