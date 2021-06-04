package com.g5.tms.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.entities.Package;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.service.IPackageService;

@RestController
@RequestMapping("/package")
public class PackageConroller {
	@Autowired
IPackageService packageService;
	@PostMapping("/add")
	public  Package  addingPackage(@RequestBody @Valid Package pack) 
	{
		Package pack1=this.packageService.addPackage(pack);
		return pack1; 
	}
	@DeleteMapping("/delete/{packageId}")
	public  Package  deletingPackage(@PathVariable int packageId) throws PackageNotFoundException
	{
		
	return this.packageService.deletePackage(packageId);
	}
	@GetMapping("/search/{packageId}")
	public  Package  searchingPackage(@PathVariable int packageId) throws PackageNotFoundException
	{
		Package pack=this.packageService.searchPackage(packageId);
		return pack;
	}
	@GetMapping("/all")
	public  List< @NotEmpty Package> viewAllPackages()
	{
		List<Package> list= this.packageService.viewAllPackages();
		return list;
	}
}
