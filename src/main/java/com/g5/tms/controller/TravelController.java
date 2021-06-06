package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.g5.tms.dto.BookingDto;
import com.g5.tms.dto.CustomerDto;
import com.g5.tms.dto.PackageDto;
import com.g5.tms.dto.TravelsDto;
import com.g5.tms.entities.Booking;
import com.g5.tms.entities.Customer;
import com.g5.tms.entities.Package;
import com.g5.tms.entities.Travels;
import com.g5.tms.entityDto.TravelsEntityDto;
import com.g5.tms.exceptions.TravelsNotFoundException;
import com.g5.tms.service.ITravelsService;

import ch.qos.logback.core.net.LoginAuthenticator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/travel")
@Api("Travel Management Application")
public class TravelController {
	@Autowired
	ITravelsService travelService;
	@Autowired
	private ModelMapper modelMapper;
	
	Logger log = LoggerFactory.getLogger(TravelController.class);
	
	
	@ApiOperation(value = "Travels Post mapping to add travels", response = Travels.class)
	@PostMapping("/add")
	public ResponseEntity<TravelsDto> addTravels(@RequestBody @Valid TravelsEntityDto requesttrvel) {
	
		log.info("Inside add travels");
	Travels actualtravel = modelMapper.map(requesttrvel, Travels.class);
	TravelsDto responsetravel = modelMapper.map(this.travelService.addTravels(actualtravel), TravelsDto.class);
	return new ResponseEntity<>(responsetravel, HttpStatus.OK);
	
	}

	
	@ApiOperation(value = "Travels Put mapping to update travels", response = Travels.class)
	@PutMapping("/update")
	public ResponseEntity<TravelsDto> updateTravels(@RequestBody @Valid TravelsEntityDto requesttrvel) throws TravelsNotFoundException{

		
		log.info("Inside update travels");
	Travels actualtravel = modelMapper.map(requesttrvel, Travels.class);
	TravelsDto responsetravel = modelMapper.map(this.travelService.updateTravels(actualtravel), TravelsDto.class);
	if (responsetravel != null) {
		return new ResponseEntity<>(responsetravel, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(responsetravel, HttpStatus.BAD_REQUEST);
	}
	
	}

	
	
	@ApiOperation(value = "Travels Delete mapping to delete travels", response = Travels.class)
	@DeleteMapping("/delete/{Id}")  
	public ResponseEntity<TravelsDto> removeTravels(@PathVariable int Id ) throws TravelsNotFoundException {
   
		log.info("Inside delete travels");
   	TravelsDto responsetravel = modelMapper.map(this.travelService.removeTravels(Id), TravelsDto.class);
	if (responsetravel != null) {
		return new ResponseEntity<>(responsetravel, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(responsetravel, HttpStatus.BAD_REQUEST);
	}
	
	}
	
	@ApiOperation(value = "Travels Get mapping to fetch travels using travels id")
   @GetMapping("/search/{travelsId}")
	public ResponseEntity<TravelsDto> searchTravels(@PathVariable int travelsId) throws TravelsNotFoundException {

		log.info("Inside finding travels by travels id");
	TravelsDto responsetravel = modelMapper.map(this.travelService.searchTravels(travelsId), TravelsDto.class);
	if (responsetravel != null) {
		return new ResponseEntity<>(responsetravel, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(responsetravel, HttpStatus.BAD_REQUEST);
	}
	}
    
	
	
	@ApiOperation(value = "Travels Get mapping to fetch all travels", response = List.class)
    @GetMapping("/all")
	public ResponseEntity<List<TravelsDto>>  viewTravels(){
    
		log.info("Inside get all travels");
    List<Travels> trvList = this.travelService.viewTravels();
	List<TravelsDto> trvDtoList = new ArrayList<>();
	for (Travels t : trvList) {
		TravelsDto packdto = modelMapper.map(t, TravelsDto.class);
		trvDtoList.add(packdto);
	}
	if (!(trvDtoList.isEmpty())) {
		return new ResponseEntity<>(trvDtoList, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(trvDtoList, HttpStatus.BAD_REQUEST);
	}
    
    }
    

	
}
