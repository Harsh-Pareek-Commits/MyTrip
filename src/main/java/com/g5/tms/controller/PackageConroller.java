package com.g5.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
IPackageService package_service;
	@PostMapping("/add")
	public  Package  addingPackage(@RequestBody Package pack) 
	{
		this.package_service.addPackage(pack);
		return pack;
	}
	@GetMapping("/delete/{Id}")
	public  Package  deletingPackage(@PathVariable int packageId) throws PackageNotFoundException
	{
		
	return this.package_service.deletePackage(packageId);
	}
	@GetMapping("/search/{Id}")
	public  Package  searchingPackage(@PathVariable int packageId) throws PackageNotFoundException
	{
		Package pack=this.package_service.searchPackage(packageId);
		return pack;
	}
	@GetMapping("/all")
	public  List<Package> viewAllPackages()
	{
		List<Package> list= this.package_service.viewAllPackages();
		return list;
	}
}
