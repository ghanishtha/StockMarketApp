package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.IPO;

public interface IPORepository extends JpaRepository<IPO, Integer> {

}
