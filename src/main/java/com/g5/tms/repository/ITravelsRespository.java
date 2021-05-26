package com.g5.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.tms.entities.Travels;
import com.g5.tms.exceptions.TravelsNotFoundException;
@Repository
public interface ITravelsRespository extends JpaRepository<Travels, Integer>{
	
		
	

}
