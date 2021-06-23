package com.example.demo.controller;

//import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.IPO;
import com.example.demo.response.Response;
import com.example.demo.service.IpoService;

@RestController
public class IpoController {
	
	@Autowired
	IpoService service;
	
	@PostMapping("/addIpo")
	public Response addIpo(@RequestBody IPO ipo) {
		//HashMap<String,String> map = new HashMap<>();
		
		//code incomplete
		return new Response(true, "okay");
	}
	
	@PutMapping("/updateIpo")
	public IPO updateIpo(@RequestBody IPO ipo) {
		return service.updateIpo(ipo);
	}
	
	@GetMapping("/ipos")
	public List<IPO> getIpos() {
		return service.getIpos();
	}

}
