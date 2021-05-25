package com.g5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g5.entities.Travels;
import com.g5.exceptions.TravelsNotFoundException;

public interface ITravelsRespository extends JpaRepository<Travels, Integer>{
	
		
	

}
