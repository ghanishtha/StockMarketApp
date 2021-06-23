package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
	
	@Query("select c from Company c where c.name like %?1%")
	public List<Company> getCompanyBySearch(String searchString);
	
	Company findByName(String name);

}
