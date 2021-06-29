package com.g5.tms.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.tms.entities.Route;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.repository.IRouteRepository;

@Service
public class RouteServiceImpl implements IRouteService {
	Logger log = LoggerFactory.getLogger(RouteServiceImpl.class);
	@Autowired
	IRouteRepository routeRepository;

	/*
	 * Author= Himagani Mishra Date= 24-May-2021 Method name: addRoute Parameters:
	 * Route object Return Type: route object
	 *
	 **/

	@Override
	@Transactional
	public Route addRoute(Route route) {

		try {
			String deptTime="";
			String arrTime="";
			if(route.getDepartureTime().toString().length()==6) {
				deptTime=route.getDepartureTime().toString()+":00";
			}
			else {
				 deptTime=route.getDepartureTime().toString();
			}
			if(route.getArrivalTime().toString().length()==6) {
				 arrTime=route.getArrivalTime().toString()+":00";
			}
			else {
				 arrTime=route.getArrivalTime().toString();
			}
			String dt=route.getDepartureDate().toString()+" "+deptTime;
			String at=route.getArrivalDate().toString()+" "+arrTime;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			LocalDateTime start = LocalDateTime.parse(dt, formatter);
			LocalDateTime end = LocalDateTime.parse(at, formatter);
		   long dur = Duration.between(start, end).getSeconds();
			long d = dur / 60;
			 Duration durr = Duration.ofMinutes(d);
		        long days = durr.toDays();
		        long hours = durr.toHours() % 24;
		        long minutes = durr.toMinutes() % 60;
		       String duration="";
		        if(days>0) {
		    	   duration=days+" day/s";
		       }
		       if(hours>0) {
		    	  duration+=" "+ hours+" hr";
		       }
		       if(minutes>0) {
		    	   duration+=" "+ minutes+" min";
		       }
		       route.setDuration(duration);
               routeRepository.save(route);
		} catch (Exception e) {
			log.error("Add route Exception:", e);
		}
		return route;
	}

	/*
	 * Author= Himagani Mishra Date= 24-May-2021 Method name: updateRoute
	 * Parameters: Route object Return Type: route object
	 *
	 **/

	@Override
	@Transactional
	public Route updateRoute(Route route) throws RouteNotFoundException {

		try {
			Optional<Route> opt = routeRepository.findById(route.getRouteId());
			if (opt.isPresent()) {
				routeRepository.save(route);
				return opt.get();
			} else {
				throw new RouteNotFoundException("Route not found in update route!");
			}
		} catch (Exception e) {

			throw new RouteNotFoundException("Route not found in update route!");
		}

	}

	/*
	 * Author= Himagani Mishra Date= 24-May-2021 Method name: removeRoute
	 * Parameters: Route Id Return Type: Route object
	 *
	 **/

	@Override
	@Transactional
	public Route removeRoute(int routeId) throws RouteNotFoundException {

		try {
			Optional<Route> opt = routeRepository.findById(routeId);
			if (opt.isPresent()) {
				routeRepository.deleteById(routeId);
				return opt.get();
			} else {
				throw new RouteNotFoundException("Route not found in remove route!");
			}
		} catch (Exception e) {

			throw new RouteNotFoundException("Route not found in remove route!");
		}

	}

	/*
	 * Author= Himagani Mishra Date= 24-May-2021 Method name: searchRoute
	 * Parameters: Route Id Return Type: Route object
	 *
	 **/

	@Override
	public Route searchRoute(int routeId) throws RouteNotFoundException {

		try {
			Optional<Route> opt = routeRepository.findById(routeId);
			if (opt.isPresent()) {
				return opt.get();
			} else {
				throw new RouteNotFoundException("Route not found in search route!");
			}
		} catch (Exception e) {

			throw new RouteNotFoundException("Route not found in search route!");
		}
	}

	/*
	 * Author= Himagani Mishra Date= 24-May-2021 Method name: viewRouteReport Return
	 * Type: Report object list
	 *
	 **/

	@Override
	public List<Route> viewRouteList() {

		List<Route> routeList = null;
		try {
			routeList = routeRepository.findAll();
		} catch (Exception e) {
			log.error("View route list Exception:", e);

		}

		return routeList;
	}

}
