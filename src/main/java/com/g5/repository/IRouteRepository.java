package com.g5.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g5.entities.Route;
import com.g5.exceptions.RouteNotFoundException;

public interface IRouteRepository extends JpaRepository<Route, Integer> {
	

	
	
	

}
