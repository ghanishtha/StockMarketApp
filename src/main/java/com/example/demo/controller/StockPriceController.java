package com.example.demo.controller;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CompanyCode;
import com.example.demo.entity.StockExchange;
import com.example.demo.entity.StockPrice;
import com.example.demo.service.CompanyCodeService;
import com.example.demo.service.StockExchangeService;
import com.example.demo.service.StockPriceService;

@RestController
public class StockPriceController {
	
	@Autowired
	StockPriceService service;
	
	//@Autowired
	CompanyCodeService companyCodeService;
	
	@Autowired
	StockExchangeService stockExchangeService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
	
	@PostMapping("/addStockPrice")
	public String addStockPrice(@RequestBody List<StockPrice> stockPrice) {
		int code;
		CompanyCode companyCode;
		
		StockExchange stockExchange;
		for(StockPrice s: stockPrice) {
			code = s.getCode().getCode();
			companyCode = companyCodeService.findByCompanyCode(code);
			s.setCode(companyCode);
			stockExchange = stockExchangeService.getByStockExchangeName(s.getStockExchange().getStockExchangeName());
			s.setStockExchange(stockExchange);
			service.saveStockPrice(s);			
		}
		
		return "Added Successfully!";
	}
	
	/*@GetMapping("/getCompanyStockPrice/{companyCode}/{from}/{to}")
	public List<StockPrice> getCompanyStockPrice(@PathVariable int companyCode, @PathVariable String from, @PathVariable String to) throws ParseException {
		Date _from = sdf.parse(from);
		Date _to = sdf.parse(to);
		CompanyCode _companyCode = companyCodeService.findByCompanyCode(companyCode);
		return service.getStockPriceByDates(_from,_to,_companyCode.getId());
	}*/
	
}
