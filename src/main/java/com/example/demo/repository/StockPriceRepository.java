package com.example.demo.repository;

//import java.util.Date;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, Integer>{

	//List<StockPrice> getStockPriceByDate(Date _from, Date _to, int id);

	
	
}
