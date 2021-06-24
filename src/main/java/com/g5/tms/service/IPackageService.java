package com.g5.tms.service;



import java.util.List;
import java.util.Optional;

import com.g5.tms.entities.Package;
import com.g5.tms.exceptions.PackageNotFoundException;

public interface IPackageService {
	
	
	public  Package  addPackage(Package pack) throws PackageNotFoundException;
	public  Package  deletePackage(int packageId) throws PackageNotFoundException;
	public  Package  searchPackage(int packageId) throws PackageNotFoundException;
	public  List<Package> viewAllPackages(Optional<String> sortBy, Optional<String> sort);
	public List<Package> viewByRoute(String from, String to, Optional<String> sortBy, Optional<String> sort ) throws PackageNotFoundException;
	public Package searchPackagebyName(String name) throws PackageNotFoundException;
	public  Package  deletePackagebyName(String name) throws PackageNotFoundException;
}
