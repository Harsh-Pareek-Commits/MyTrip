package com.g5.tms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.tms.entities.Route;
import com.g5.tms.exceptions.RouteNotFoundException;
@Repository
public interface IRouteRepository extends JpaRepository<Route, Integer> {
	

	
	
	

}
