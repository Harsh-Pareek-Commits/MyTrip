package com.g5.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.tms.entities.Travels;
@Repository
public interface ITravelsRespository extends JpaRepository<Travels, Integer>{
	
	
		
	

}
