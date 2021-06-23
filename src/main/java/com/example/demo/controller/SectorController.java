package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Company;
import com.example.demo.entity.Sector;
import com.example.demo.service.SectorService;

@RestController
public class SectorController {
	
	@Autowired
	SectorService service;
	
	@GetMapping("/sectors")
	public List<Sector> getSectors(){
		return service.findAll();
	}
	
	@GetMapping("/sectors/{id}")
	public List<Company> getCompanyFromSector(@PathVariable int id) {
		Sector sector = service.findById(id);
		return sector.getCompanies();
	}
	
	@PostMapping("/sectors")
	public Sector addSector(@RequestBody Sector sector) {
		return service.addSector(sector);
	}
	
	@PutMapping("/sectors/{id}")
	public Sector updateSector(@PathVariable int id, @RequestBody Sector sector) {
		return service.updateSector(id, sector);
	}

}
