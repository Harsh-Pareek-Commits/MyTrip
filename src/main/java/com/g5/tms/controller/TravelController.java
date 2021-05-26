package com.g5.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.entities.Customer;
import com.g5.tms.entities.Travels;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.exceptions.TravelsNotFoundException;
import com.g5.tms.service.ITravelsService;

@RestController
@RequestMapping("/travel")
public class TravelController {
	@Autowired
ITravelsService travel_service;
	
	@PostMapping("/add")
	public Travels addTravels(@RequestBody Travels trv) {
	this.travel_service.addTravels(trv);
	return trv;
	}

	@PutMapping("/update")
	public Travels updateTravels(@RequestBody Travels trv) throws TravelsNotFoundException{
	this.travel_service.updateTravels(trv);
	return trv;
	}


	@DeleteMapping("/delete")  
	public Travels removeTravels(@RequestBody Travels trv) throws TravelsNotFoundException {
   	 this.travel_service.removeTravels(trv.getTravelsId());
		return trv;
	}
   @GetMapping("/search/{Id}")
	public Travels searchTravels(@PathVariable int travelsId) throws TravelsNotFoundException {
   	Travels trv;
   	trv=this.travel_service.searchTravels(travelsId);
	return trv;
	}
    
   
    @GetMapping("/all")
	public  List<Travels>  viewTravels(){
    List<Travels> list = travel_service.viewTravels(); 
    return list;
    }
    

	
}
