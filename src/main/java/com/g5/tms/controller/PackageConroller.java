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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.dto.PackageDto;
import com.g5.tms.entities.Package;
import com.g5.tms.entitydto.PackageEntityDto;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.service.IPackageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/package")
@Api("Travel Management Application")
public class PackageConroller {
	@Autowired
	IPackageService packageService;
	@Autowired
	private ModelMapper modelMapper;
	/*
	 *Author= Iflak Yousuf Mir
	 *Date= 26-May-2021
	 *Method name: addPackage
	 *Parameters: packageEntityDto object
	 *Return Type: packageDto object
	 *
	 **/
	@ApiOperation(value ="Package Post mapping to add package", response = Package.class)
	@PostMapping("/add")
	public  ResponseEntity<PackageDto>  addingPackage(@RequestBody @Valid PackageEntityDto requestpack) 
	{
	 
	Package actualpack = modelMapper.map(requestpack, Package.class);
		PackageDto responsepack = modelMapper.map(this.packageService.addPackage(actualpack), PackageDto.class);
		return new ResponseEntity<>(responsepack, HttpStatus.OK);
	}
	/*
	 *Author= Iflak Yousuf Mir
	 *Date= 26-May-2021
	 *Method name: deletingPackage
	 *Parameters: packageid
	 *Return Type: packageDto object
	 *
	 **/
	@ApiOperation(value = "Package Delete mapping to delete package", response = Package.class)
	@DeleteMapping("/delete/{packageId}")
	public ResponseEntity<PackageDto> deletingPackage(@PathVariable int packageId) throws PackageNotFoundException
	{
		
	PackageDto responsepack = modelMapper.map(this.packageService.deletePackage(packageId), PackageDto.class);
	if (responsepack != null) {
		return new ResponseEntity<>(responsepack, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(responsepack, HttpStatus.BAD_REQUEST);
	}
	}
	/*
	 *Author= Iflak Yousuf Mir
	 *Date= 26-May-2021
	 *Method name: searchingPackage
	 *Parameters: packageid
	 *Return Type: packageDto object
	 *
	 **/
	@ApiOperation(value = "Package Get mapping to fetch package by package id", response = Package.class)
	@GetMapping("/search/{packageId}")
	public  ResponseEntity<PackageDto>  searchingPackage(@PathVariable int packageId) throws PackageNotFoundException
	{
		 PackageDto responsepack = modelMapper.map(this.packageService.searchPackage(packageId), PackageDto.class);
			if (responsepack != null) {
				return new ResponseEntity<>(responsepack, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(responsepack, HttpStatus.BAD_REQUEST);
			}
	}
	
	/*
	 *Author= Iflak Yousuf Mir
	 *Date= 26-May-2021
	 *Method name: viewAllPackages
	 *Parameters: none
	 *Return Type: list of packageDto objects
	 *
	 **/
	@ApiOperation(value = "Package Get mapping to fetch all packages", response = List.class)
	@GetMapping("/all")
	public  ResponseEntity<List<PackageDto>> viewAllPackages()
	{
		   List<Package> packList = this.packageService.viewAllPackages();
			List<PackageDto> packDtoList = new ArrayList<>();
			for (Package p : packList) {
				PackageDto packdto = modelMapper.map(p, PackageDto.class);
				packDtoList.add(packdto);
			}
			if (!(packDtoList.isEmpty())) {
				return new ResponseEntity<>(packDtoList, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(packDtoList, HttpStatus.BAD_REQUEST);
			}
	}
}
