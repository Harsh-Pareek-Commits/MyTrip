package com.g5.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.tms.entities.Route;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.repository.IReportRepository;
import com.g5.tms.repository.IRouteRepository;

@Service
public class RouteServiceImpl implements IRouteService {
	Logger log = LoggerFactory.getLogger(RouteServiceImpl.class);
	@Autowired
	IRouteRepository route_repository;

	@Override
	@Transactional
	public Route addRoute(Route route) {

		try {

			route_repository.save(route);
			
		} catch (Exception e) {
			log.error("Add route Exception:", e);
		}
		return route;
	}

	@Override
	@Transactional
	public Route updateRoute(Route route) throws RouteNotFoundException {
		Optional<Route> opt = null;
		try {
			opt = route_repository.findById(route.getRouteId());
			if (opt.isPresent()) {
				route_repository.save(route);
			} else {
				throw new RouteNotFoundException("Route not found in update route!");
			}
		} catch (Exception e) {
			
			throw new RouteNotFoundException("Route not found in update route!");
		}

		return opt.get();
	}

	@Override
	@Transactional
	public Route removeRoute(int routeId) throws RouteNotFoundException {
		Optional<Route> opt = null;

		try {
			opt = route_repository.findById(routeId);
			if (opt.isPresent()) {
				route_repository.deleteById(routeId);
			} else {
				throw new RouteNotFoundException("Route not found in remove route!");
			}
		} catch (Exception e) {
			
			throw new RouteNotFoundException("Route not found in remove route!");
		}
		return opt.get();
	}

	@Override
	public Route searchRoute(int routeId) throws RouteNotFoundException {

		try {
			Optional<Route>opt= route_repository.findById(routeId);
			if(opt.isPresent()) {
			return opt.get();
			}else {
				throw new RouteNotFoundException("Route not found in search route!");
			}
		} catch (Exception e) {
			
			throw new RouteNotFoundException("Route not found in search route!");
		}
	}

	@Override
	public List<Route> viewRouteList() {

		List<Route> routeList = null;
		try {
			routeList = route_repository.findAll();
		} catch (Exception e) {
			log.error("View route list Exception:", e);

		}

		return routeList;
	}

}
