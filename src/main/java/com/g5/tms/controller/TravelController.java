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

import com.g5.tms.dto.TravelsDto;
import com.g5.tms.entities.Travels;
import com.g5.tms.entitydto.TravelsEntityDto;
import com.g5.tms.exceptions.TravelsNotFoundException;
import com.g5.tms.service.ITravelsService;
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
	
	
	
	@ApiOperation(value = "Travels Post mapping to add travels", response = Travels.class)
	@PostMapping("/add")
	public ResponseEntity<TravelsDto> addTravels(@RequestBody @Valid TravelsEntityDto requesttrvel) {
	
	Travels actualtravel = modelMapper.map(requesttrvel, Travels.class);
	System.out.println(requesttrvel);
	System.out.println(actualtravel);
	TravelsDto responsetravel = modelMapper.map(this.travelService.addTravels(actualtravel), TravelsDto.class);
	return new ResponseEntity<>(responsetravel, HttpStatus.OK);
	
	}

	
	@ApiOperation(value = "Travels Put mapping to update travels", response = Travels.class)
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

	
	
	@ApiOperation(value = "Travels Delete mapping to delete travels", response = Travels.class)
	@DeleteMapping("/delete/{id}")  
	public ResponseEntity<TravelsDto> removeTravels(@PathVariable int id ) throws TravelsNotFoundException {
    	TravelsDto responsetravel = modelMapper.map(this.travelService.removeTravels(id), TravelsDto.class);
	if (responsetravel != null) {
		return new ResponseEntity<>(responsetravel, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(responsetravel, HttpStatus.BAD_REQUEST);
	}
	
	}
	
	@ApiOperation(value = "Travels Get mapping to fetch travels using travels id")
   @GetMapping("/search/{travelsId}")
	public ResponseEntity<TravelsDto> searchTravels(@PathVariable int travelsId) throws TravelsNotFoundException {
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
