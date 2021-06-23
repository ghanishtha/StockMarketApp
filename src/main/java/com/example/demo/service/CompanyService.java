package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository repository;
	
	public boolean isNameUnique(String name) {
		Company company = repository.findByName(name);
		if(company != null) {
			return false;
		}
		else return true;
	}
	
	public Company addCompany(Company company) {
		Company c = new Company();
		c.setBoardOfDirectors(company.getBoardOfDirectors());
		c.setTurnover(company.getTurnover());
		c.setCeo(company.getCeo());
		c.setIpo(company.getIpo());
		c.setName(company.getName());
		c.setWriteUp(company.getWriteUp());
		repository.save(c);
		return c;
	}
	
	public Company updateCompany(int id,Company company) {
		Company existing = repository.findById(id).orElse(null);
		existing.setTurnover(company.getTurnover());
		existing.setBoardOfDirectors(company.getBoardOfDirectors());
		existing.setCeo(company.getCeo());
		existing.setWriteUp(company.getWriteUp());
		return repository.save(existing);
		
	}

	public Company findById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Company> searchCompany(String searchString) {
		return repository.getCompanyBySearch(searchString);
	}

	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
