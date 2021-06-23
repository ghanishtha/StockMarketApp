package com.example.demo.controller;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Company;
import com.example.demo.entity.IPO;
import com.example.demo.response.Response;
import com.example.demo.service.CompanyService;

@RestController
//@CrossOrigin("http://localhost:3000")
public class CompanyController {
	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CompanyService service;

	@GetMapping("/companies")
	public List<Company> getCompanies(){
		return service.getAllCompanies();
	}
	
	
	@PostMapping("/companies")
	public Response addCompany(@RequestBody Company company) {
		boolean uniqueName = service.isNameUnique(company.getName());
		if(!uniqueName) {
			return new Response(false, "Company already exists!");
		}
		else {
			service.addCompany(company);
			return new Response(true, "Saved!");
		}
	}

	
	
	@PutMapping("/updateCompany/{id}")
	public Company updateCompany(@PathVariable int id,@RequestBody Company company) {
		return service.updateCompany(id,company);
	}
	
	@GetMapping("/getIpoFromCompany/{id}")
	public IPO getIpoFromCompany(@PathVariable int id) {
		Company company = service.findById(id);
		return company.getIpo();
	}
	
	@GetMapping("/searchCompany/{searchString}")
	public List<Company> searchCompany(@PathVariable String searchString) {
		return service.searchCompany(searchString);
	}

}
