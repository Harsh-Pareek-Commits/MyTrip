package com.g5.tms.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.entities.Route;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.service.IRouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	@Autowired
    IRouteService route_services;
	
	@PostMapping("/add")
	public Route addRoute(@RequestBody @Valid Route rout) {

		this.route_services.addRoute(rout);
		return rout;
	}
	@PutMapping("/update")
	public Route updateRoute(@RequestBody @Valid Route rout) throws RouteNotFoundException {
		this.route_services.updateRoute(rout);
		return rout;
	}
	
	@GetMapping("/view/{id}")
	public Route searchRoute(@PathVariable int id) throws RouteNotFoundException {
		Route rout = this.route_services.searchRoute(id);
		return rout;	
	}
	
	@DeleteMapping("/remove/{id}")
	public Route removeRoute(@PathVariable int id) throws RouteNotFoundException {
   	 Route rout = this.route_services.removeRoute(id);
		return rout;
	}
	@GetMapping("/all")
	 public List<@NotBlank Route> viewRoute(){
	    return route_services.viewRouteList();
	}

	}

