package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Sector;

public interface SectorRepository extends JpaRepository<Sector,Integer> {

}
