package com.g5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.entities.Travels;
import com.g5.exceptions.TravelsNotFoundException;
@Repository
public interface ITravelsRespository extends JpaRepository<Travels, Integer>{
	
		
	

}
