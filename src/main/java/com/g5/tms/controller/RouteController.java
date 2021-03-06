package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.g5.tms.entitydto.RouteEntityDto;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.service.IRouteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/route")
@Api("Travel Management Application")
public class RouteController {
	@Autowired
    IRouteService routeServices;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/*
	 *Author= Himagani Mishra
	 *Date= 26-May-2021
	 *Method name: addRoute
	 *Parameters: RouteEntityDto object
	 *Return Type: RouteDto object
	 *
	 **/
	
	@ApiOperation(value = "Route Post mapping to add route", response = Route.class)
	@PostMapping("/add")
	public ResponseEntity<RouteDto> addRoute(@RequestBody @Valid RouteEntityDto requestRoute) {
	Route actualRoute = modelMapper.map(requestRoute, Route.class);
		RouteDto responseRoute = modelMapper.map(this.routeServices.addRoute(actualRoute), RouteDto.class);
		return new ResponseEntity<>(responseRoute, HttpStatus.OK);
	}
	
	/*
	 *Author= Himagani Mishra
	 *Date= 26-May-2021
	 *Method name: updateRoute
	 *Parameters: RouteEntityDto object
	 *Return Type: RouteDto object
	 *
	 **/
	
	@ApiOperation(value = "Route Put mapping to update route", response = Route.class)
	@PutMapping("/update")
	public ResponseEntity<RouteDto> updateRoute(@RequestBody @Valid RouteEntityDto requestRoute) throws RouteNotFoundException  {
		
		Route actualRoute = modelMapper.map(requestRoute, Route.class);
		RouteDto responseRoute = modelMapper.map(this.routeServices.addRoute(actualRoute), RouteDto.class);

		if (responseRoute != null) {
			return new ResponseEntity<>(responseRoute, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseRoute, HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 *Author= Himagani Mishra
	 *Date= 26-May-2021
	 *Method name: viewRoute
	 *Parameters: Route Id
	 *Return Type: RouteDto object
	 *
	 **/
	
	@ApiOperation(value = "Route Get mapping to fetch route by route id")
	@GetMapping("/view/{routeid}")
	public ResponseEntity<RouteDto> viewRoutebyId(@PathVariable int routeid) throws RouteNotFoundException {
	RouteDto responseroute = modelMapper.map(this.routeServices.searchRoute(routeid), RouteDto.class);
		if (responseroute != null) {
			return new ResponseEntity<>(responseroute, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseroute, HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 *Author= Himagani Mishra
	 *Date= 26-May-2021
	 *Method name: deleteRoute
	 *Parameters: Route Id
	 *Return Type: RouteDto object
	 *
	 **/
	
	@ApiOperation(value = "Route Delete mapping to delete route", response = Route.class)
	@DeleteMapping("/remove/{routeId}")
	public ResponseEntity<RouteDto> deleteRoute(@PathVariable int routeId) throws RouteNotFoundException {
		RouteDto responseroute = modelMapper.map(this.routeServices.removeRoute(routeId), RouteDto.class);
		if (responseroute != null) {
			return new ResponseEntity<>(responseroute, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseroute, HttpStatus.NOT_FOUND);
		}
		 
	}
	
	/*
	 *Author= Himagani Mishra
	 *Date= 26-May-2021
	 *Method name: viewAllRoutes
	 *Return Type: RouteDto object list
	 *
	 **/
	
	@ApiOperation(value = "Route Get mapping to fetch all routes", response = List.class)
	@GetMapping("/all")
	public ResponseEntity<List<RouteDto>> viewAllRoutes() {
	       
	  List<Route> routeList = this.routeServices.viewRouteList();
		List<RouteDto> routeDtoList = new ArrayList<>();
		for (Route r : routeList) {
			RouteDto routedto = modelMapper.map(r, RouteDto.class);
			routeDtoList.add(routedto);
		}
		if (!(routeDtoList.isEmpty())) {
			return new ResponseEntity<>(routeDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(routeDtoList, HttpStatus.NOT_FOUND);
		}
	}
	
	

	}

