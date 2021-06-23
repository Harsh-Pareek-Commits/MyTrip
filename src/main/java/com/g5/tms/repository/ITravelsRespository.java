package com.g5.tms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.g5.tms.entities.Travels;
@Repository
public interface ITravelsRespository extends JpaRepository<Travels, Integer>{
	
	@Query("select t from Travels t where t.travelsName=:travelsName")
	Optional<Travels> findByName(@Param("travelsName") String travelsName);
		
	

}
