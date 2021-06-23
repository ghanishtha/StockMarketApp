package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.IPO;
import com.example.demo.repository.IPORepository;

@Service
public class IpoService {
	
	@Autowired
	IPORepository repository;
	
	public IPO saveIpo(IPO ipo) {
		return repository.save(ipo);
	}

	public IPO updateIpo(IPO ipo) {
		// TODO Auto-generated method stub
		IPO existing = repository.findById(ipo.getId()).orElse(null);
		existing.setPricerPerShare(ipo.getPricerPerShare());
		existing.setTotalShares(ipo.getTotalShares());
		existing.setOpenDateTime(ipo.getOpenDateTime());
		existing.setRemarks(ipo.getRemarks());
		return repository.save(existing);
	}

	public List<IPO> getIpos() {
		// TODO Auto-generated method stub
		List<IPO> ipos = repository.findAll();
		return ipos;
	}

}
