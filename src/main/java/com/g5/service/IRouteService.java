package com.g5.service;


import java.util.List;

import com.g5.entities.Route;
import com.g5.exceptions.RouteNotFoundException;


public interface IRouteService {
	
	
	public  Route  addRoute(Route route);
	public  Route  updateRoute(Route route) throws RouteNotFoundException;
	public  Route   removeRoute(int routeId) throws RouteNotFoundException;
	public  Route    searchRoute(int routeId) throws RouteNotFoundException;
	public  List<Route> viewRouteList();
	
	
	
	

}
