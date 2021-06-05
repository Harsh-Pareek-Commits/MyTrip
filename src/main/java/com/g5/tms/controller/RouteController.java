package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.g5.tms.dto.RouteDto;
import com.g5.tms.entities.Route;
import com.g5.tms.entityDto.RouteEntityDto;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.service.IRouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	@Autowired
    IRouteService routeServices;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@PostMapping("/add")
	public ResponseEntity<RouteDto> addRoute(@RequestBody @Valid RouteEntityDto requestRoute) {

		Route actualRoute = modelMapper.map(requestRoute, Route.class);
		RouteDto responseRoute = modelMapper.map(this.routeServices.addRoute(actualRoute), RouteDto.class);
		return new ResponseEntity<>(responseRoute, HttpStatus.OK);
	}
	
	/*public Route addRoute(@RequestBody @Valid Route rout) {

		this.routeServices.addRoute(rout);
		return rout;
	}*/
	@PutMapping("/update")
	
	public ResponseEntity<RouteDto> updateRoute(@RequestBody @Valid RouteEntityDto requestRoute)
			throws RouteNotFoundException {
		Route actualRoute = modelMapper.map(requestRoute, Route.class);
		RouteDto responseRoute = modelMapper.map(this.routeServices.addRoute(actualRoute), RouteDto.class);

		if (responseRoute != null) {
			return new ResponseEntity<>(responseRoute, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseRoute, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/view/{routeid}")
	public ResponseEntity<RouteDto> viewRoutebyId(@PathVariable int routeid) throws RouteNotFoundException {

		RouteDto responseroute = modelMapper.map(this.routeServices.searchRoute(routeid), RouteDto.class);
		if (responseroute != null) {
			return new ResponseEntity<>(responseroute, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseroute, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping("/remove/{routeId}")
	public ResponseEntity<RouteDto> deleteRoute(@PathVariable int routeId) throws RouteNotFoundException {
		RouteDto responseroute = modelMapper.map(this.routeServices.removeRoute(routeId), RouteDto.class);
		if (responseroute != null) {
			return new ResponseEntity<>(responseroute, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseroute, HttpStatus.BAD_REQUEST);
		}
		 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<RouteDto>> viewAllRoutes() {
	       
        List<Route> routeList = this.routeServices.viewRouteList();
		List<RouteDto> RouteDtoList = new ArrayList<>();
		for (Route r : routeList) {
			RouteDto routedto = modelMapper.map(r, RouteDto.class);
			RouteDtoList.add(routedto);
		}
		if (!(RouteDtoList.isEmpty())) {
			return new ResponseEntity<>(RouteDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(RouteDtoList, HttpStatus.BAD_REQUEST);
		}
	}
	
	

	}

