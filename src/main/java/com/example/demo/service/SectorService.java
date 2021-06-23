package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Sector;
import com.example.demo.repository.SectorRepository;

@Service
public class SectorService {
	
	@Autowired
	SectorRepository repository;

	public Sector findById(int id) {
		// TODO Auto-generated method stub
		
		return repository.findById(id).orElse(null);
	}
	
	public List<Sector> findAll() {
		return repository.findAll();
	}
	
	public Sector addSector(Sector sector) {
		Sector s = new Sector();
		s.setBrief(sector.getBrief());
		s.setSectorName(sector.getSectorName());
		return repository.save(s);
	}
	
	public Sector updateSector(int id, Sector sector) {
		Sector s = repository.getById(id);
		s.setBrief(sector.getBrief());
		s.setSectorName(sector.getSectorName());
		return s;
		
	}

}
