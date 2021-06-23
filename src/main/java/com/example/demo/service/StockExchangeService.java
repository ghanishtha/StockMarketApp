package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StockExchange;
import com.example.demo.repository.StockExchangeRepository;

@Service
public class StockExchangeService {

	@Autowired
	StockExchangeRepository repository;
	
	public StockExchange saveStockexchange(StockExchange stockExchange) {
		// TODO Auto-generated method stub		
		StockExchange s = new StockExchange();
		s.setStockExchangeName(stockExchange.getStockExchangeName());
		s.setAddress(stockExchange.getAddress());
		s.setBrief(stockExchange.getBrief());
		s.setRemarks(stockExchange.getRemarks());
		return repository.save(s);
	}

	public List<StockExchange> getAllStockExchanges() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public StockExchange findById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	public StockExchange getByStockExchangeName(String name) {
		return repository.findByStockExchangeName(name);
	}
	

}
