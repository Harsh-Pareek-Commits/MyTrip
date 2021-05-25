package com.g5.service;



import java.util.List;

import com.g5.entities.Package;
import com.g5.exceptions.PackageNotFoundException;

public interface IPackageService {
	
	
	public  Package  addPackage(Package pack);
	public  Package  deletePackage(int packageId) throws PackageNotFoundException;
	public  Package  searchPackage(int packageId) throws PackageNotFoundException;
	public  List<Package> viewAllPackages();
	
	
}
