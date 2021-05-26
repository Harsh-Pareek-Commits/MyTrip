package com.g5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.entities.Route;
import com.g5.exceptions.RouteNotFoundException;
import com.g5.repository.IReportRepository;
import com.g5.repository.IRouteRepository;
@Service
public class RouteServiceImpl implements IRouteService {
	
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
	@Transactional
	public Route updateRoute(Route route) throws RouteNotFoundException {
		Optional<Route> opt=null;
		try {
			opt=route_repository.findById(route.getRouteId());
			route_repository.save(route);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RouteNotFoundException("Route not found!");
		}
		
		return opt.get();
	}

	@Override
	@Transactional
	public Route removeRoute(int routeId) throws RouteNotFoundException {
		Optional<Route> opt=null;
		Route route = route_repository.findById(routeId).get();
		try {
			opt=route_repository.findById(route.getRouteId());
			route_repository.deleteById(routeId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RouteNotFoundException("Route not found!");
		}
		return opt.get();
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
