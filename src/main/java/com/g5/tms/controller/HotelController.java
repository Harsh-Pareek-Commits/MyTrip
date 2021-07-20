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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.dto.FeedbackDto;
import com.g5.tms.dto.HotelDto;
import com.g5.tms.dto.PackageDto;
import com.g5.tms.entities.Feedback;
import com.g5.tms.entities.Hotel;
import com.g5.tms.entities.Package;
import com.g5.tms.entitydto.HotelEntityDto;
import com.g5.tms.exceptions.HotelNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.service.IHotelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/hotel")
@Api("Travel Management Application")
public class HotelController {
	@Autowired
	IHotelService hotelService;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@ApiOperation(value = "Hotel Post mapping to add hotel", response = Hotel.class)
	@PostMapping("/add")
	public ResponseEntity<HotelDto> addingPackage(@RequestBody @Valid HotelEntityDto requesthotel)
			throws HotelNotFoundException {

		Hotel actualhotel = modelMapper.map(requesthotel, Hotel.class);
		HotelDto responsehotel = modelMapper.map(this.hotelService.addHotel(actualhotel), HotelDto.class);
		return new ResponseEntity<>(responsehotel, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Hotel Get mapping to fetch hotel by hotel name", response = Hotel.class)
	@GetMapping("/search/hotelname/{name}")
	public ResponseEntity<HotelDto> searchingHotelbyName(@PathVariable String name)
			throws HotelNotFoundException {
		HotelDto responsehotel = modelMapper.map(this.hotelService.searchHotelbyName(name), HotelDto.class);
		if (responsehotel != null) {
			return new ResponseEntity<>(responsehotel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsehotel, HttpStatus.NOT_FOUND);
		}
	}
	@ApiOperation(value = "Hotel Get mapping to fetch hotel by hotel id", response = Hotel.class)
	@GetMapping("/search/{id}")
	public ResponseEntity<HotelDto> searchingHotelbyId(@PathVariable int id)
			throws HotelNotFoundException {
		HotelDto responsehotel = modelMapper.map(this.hotelService.getHotelByid(id), HotelDto.class);
		if (responsehotel != null) {
			return new ResponseEntity<>(responsehotel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsehotel, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@ApiOperation(value = "Hotel Get mapping to fetch all hotel by city", response = List.class)
	@GetMapping("/search/city/{city}")
	public ResponseEntity<List<HotelDto>> searchHotelbyCity(@PathVariable String city) throws HotelNotFoundException {
		List<Hotel> hotelList = this.hotelService.searchHotelbyCity(city);
		List<HotelDto> hotelDtoList = new ArrayList<>();
		for (Hotel p : hotelList) {
			HotelDto hoteldto = modelMapper.map(p, HotelDto.class);
			hotelDtoList.add(hoteldto);
		}
		if (!(hotelDtoList.isEmpty())) {
			return new ResponseEntity<>(hotelDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(hotelDtoList, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "Hotel Get mapping to fetch all hotels", response = List.class)
	@GetMapping("/view")
	public ResponseEntity<List<HotelDto>> viewAllHotel() {
	       
	   List<Hotel> hotelList = this.hotelService.viewAll();
		List<HotelDto> hotelDtoList = new ArrayList<>();
		for (Hotel f : hotelList) {
			HotelDto hoteldto = modelMapper.map(f, HotelDto.class);
			hotelDtoList.add(hoteldto);
		}
		if (!(hotelDtoList.isEmpty())) {
			return new ResponseEntity<>(hotelDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(hotelDtoList, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "Hotel Delete mapping to delete hotel", response = Hotel.class)
	@DeleteMapping("/delete/{hotelId}")
	public ResponseEntity<HotelDto> deleteHotel(@PathVariable int hotelId) throws HotelNotFoundException {
		HotelDto responsehotel = modelMapper.map(this.hotelService.deleteHotel(hotelId), HotelDto.class);
		if (responsehotel != null) {
			return new ResponseEntity<>(responsehotel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsehotel, HttpStatus.NOT_FOUND);
		}
		 
	}

}
