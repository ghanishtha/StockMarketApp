package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Company;
import com.example.demo.entity.StockExchange;
import com.example.demo.service.StockExchangeService;

@RestController
public class StockExchangeController {

	@Autowired
	StockExchangeService service;
	
	@PostMapping("/stockExchanges")
	public StockExchange addStockExchange(@RequestBody StockExchange stockExchange) {
		return service.saveStockexchange(stockExchange);
	}
	
	@GetMapping("/stockExchanges")
	public List<StockExchange> getStockExchangeList(){
		return service.getAllStockExchanges();
	}
	
	@GetMapping("/companiesFromStockExchange/{id}")
	public List<Company> getCompaniesFromStockExchange(@PathVariable int id){
		StockExchange stockExchange = service.findById(id);
		return stockExchange.getCompanies();
	}
	
}
