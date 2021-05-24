package com.g5.service;


import java.util.List;

import com.g5.exceptions.PackageNotFoundException;

public interface IPackageService {
	
	
	public  Package  addPackage(Package pack);
	public  Package  deletePackage(int packageId) throws PackageNotFoundException;
	public  Package  searchPackage(int packageId) throws PackageNotFoundException;
	public  List<Package> viewAllPackages();
	
	/*
	 * package-> iflak feedback,report,route-> himagani,jaydeep
	 * user,travels->harsha, iflak bookings and cust-> harsh service interface impl,
	 * spring controller-> url(parameter, json)-> facebook/frnds
	 */
}
