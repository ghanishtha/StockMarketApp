package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Company;
import com.example.demo.entity.Sector;
import com.example.demo.entity.StockExchange;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.SectorRepository;
import com.example.demo.repository.StockExchangeRepository;

@SpringBootApplication
public class StockMarketApplication implements CommandLineRunner{
	
	@Autowired
	SectorRepository sectorRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	StockExchangeRepository stockExchangeRepository;

	public static void main(String[] args) {
		SpringApplication.run(StockMarketApplication.class, args);
		
		System.out.println("Hello. You did well till here.");
	}
	
	public void run(String... args) throws Exception{
		
		Company company1 = new Company("name1", 1000000.00f, "ceo1", "Person1, Person2, Person3", "description1");
		companyRepository.save(company1);
		
		Company company2 = new Company("name2", 2000000.00f, "ceo2", "Person1, Person2, Person3", "description2");
		companyRepository.save(company2);
		
		Sector sector1 = new Sector("Health", "This is the health sector");
		sectorRepository.save(sector1);
		
		Sector sector2 = new Sector("Communication", "This is the communication sector");
		sectorRepository.save(sector2);
		
		StockExchange stockExchange1 = new StockExchange("NSE","National Stock Exchange","Mumbai","description1");
		stockExchangeRepository.save(stockExchange1);
		
		StockExchange stockExchange2 = new StockExchange("BSE","Bombay Stock Exchange","Mumbai","description2");
		stockExchangeRepository.save(stockExchange2);
	}

}
