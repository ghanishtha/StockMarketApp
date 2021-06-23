package com.example.demo.service;

//import java.util.Date;
//import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StockPrice;
import com.example.demo.repository.StockPriceRepository;

@Service
public class StockPriceService {
	
	@Autowired
	StockPriceRepository repository;
	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public StockPrice saveStockPrice(StockPrice s) {
		// TODO Auto-generated method stub
		return repository.save(s);
		
	}

	/*public List<StockPrice> getStockPriceByDates(Date _from, Date _to, int id) {
		// TODO Auto-generated method stub
		List<StockPrice> stockPrice = repository.getStockPriceByDate(_from,_to,id);
		for(StockPrice s : stockPrice) {
			logger.info("**********blah***********");
			logger.info(s.toString());
		}
		return repository.getStockPriceByDate(_from,_to,id);
	}*/

}
