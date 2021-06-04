package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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

@RestController
@RequestMapping("/travel")
public class TravelController {
	@Autowired
ITravelsService travelService;
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/add")
	public ResponseEntity<TravelsDto> addTravels(@RequestBody @Valid TravelsEntityDto requesttrvel) {
	
	Travels actualtravel = modelMapper.map(requesttrvel, Travels.class);
	TravelsDto responsetravel = modelMapper.map(this.travelService.addTravels(actualtravel), TravelsDto.class);
	return new ResponseEntity<>(responsetravel, HttpStatus.OK);
	
	}

	@PutMapping("/update")
	public ResponseEntity<TravelsDto> updateTravels(@RequestBody @Valid TravelsEntityDto requesttrvel) throws TravelsNotFoundException{

	Travels actualtravel = modelMapper.map(requesttrvel, Travels.class);
	TravelsDto responsetravel = modelMapper.map(this.travelService.updateTravels(actualtravel), TravelsDto.class);
	if (responsetravel != null) {
		return new ResponseEntity<>(responsetravel, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(responsetravel, HttpStatus.BAD_REQUEST);
	}
	
	}


	@DeleteMapping("/delete/{Id}")  
	public ResponseEntity<TravelsDto> removeTravels(@PathVariable int Id ) throws TravelsNotFoundException {
   
   	TravelsDto responsetravel = modelMapper.map(this.travelService.removeTravels(Id), TravelsDto.class);
	if (responsetravel != null) {
		return new ResponseEntity<>(responsetravel, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(responsetravel, HttpStatus.BAD_REQUEST);
	}
	
	}
   @GetMapping("/search/{travelsId}")
	public ResponseEntity<TravelsDto> searchTravels(@PathVariable int travelsId) throws TravelsNotFoundException {

	TravelsDto responsetravel = modelMapper.map(this.travelService.searchTravels(travelsId), TravelsDto.class);
	if (responsetravel != null) {
		return new ResponseEntity<>(responsetravel, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(responsetravel, HttpStatus.BAD_REQUEST);
	}
	}
    
   
    @GetMapping("/all")
	public ResponseEntity<List<TravelsDto>>  viewTravels(){
    
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
