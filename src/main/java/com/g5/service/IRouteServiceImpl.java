package com.g5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.g5.entities.Route;
import com.g5.exceptions.RouteNotFoundException;
import com.g5.repository.IReportRepository;
import com.g5.repository.IRouteRepository;

public class IRouteServiceImpl implements IRouteService {
	
	@Autowired
	IRouteRepository route_repository;

	@Override
	@Transactional
	public Route addRoute(Route route) {
		// TODO Auto-generated method stub
		try 
		{
			route_repository.save(route);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return route;
	}

	@Override
	public Route updateRoute(Route route) throws RouteNotFoundException {
		// TODO Auto-generated method stub
		try {
			route_repository.save(route);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RouteNotFoundException("Route not found!");
		}
		
		return route;
	}

	@Override
	public Route removeRoute(int routeId) throws RouteNotFoundException {
		// TODO Auto-generated method stub
		Route route = route_repository.findById(routeId).get();
		try {
			route_repository.deleteById(routeId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RouteNotFoundException("Route not found!");
		}
		return route;
	}

	@Override
	public Route searchRoute(int routeId) throws RouteNotFoundException {
		// TODO Auto-generated method stub
		
		try {
			return route_repository.findById(routeId).get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RouteNotFoundException("Route not foound!");
		}
	}

	@Override
	public List<Route> viewRouteList() {
		// TODO Auto-generated method stub
		List<Route> routeList = null;
		try {
			routeList = route_repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return routeList;
	}

}
