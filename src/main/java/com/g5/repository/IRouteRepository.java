package com.g5.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.entities.Route;
import com.g5.exceptions.RouteNotFoundException;
@Repository
public interface IRouteRepository extends JpaRepository<Route, Integer> {
	

	
	
	

}
