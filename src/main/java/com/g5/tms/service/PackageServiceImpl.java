package com.g5.tms.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.lang.String.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.tms.entities.Hotel;
import com.g5.tms.entities.Package;

import com.g5.tms.exceptions.PackageNotFoundException;

import com.g5.tms.repository.IPackageRepository;

@Service
public class PackageServiceImpl implements IPackageService {
	Logger log = LoggerFactory.getLogger(PackageServiceImpl.class);
	@Autowired
	IPackageRepository packageRepository;

	@Override
	@Transactional
	/*
	 * Author= Iflak Yousuf Mir Date= 24-May-2021 Method name: addPackage
	 * Parameters: package object Return Type: package object
	 *
	 **/
	public Package addPackage(Package pack) throws PackageNotFoundException {
		Optional<Package> opt = null;
		try {

			opt = packageRepository.findByName(pack.getPackageName());
			if (opt.isPresent()) {
				throw new PackageNotFoundException("PackageName already exists");
			} else {
				double total = pack.getRoute().getFare();
			//	total += pack.getHotel().;
				total += pack.getPackageCost();
				pack.setPackageCost(total);
				return packageRepository.save(pack);
			}
		} catch (Exception e) {
			throw new PackageNotFoundException("Package cannot be added");
		}
	}

	@Override
	@Transactional
	/*
	 * Author= Iflak Yousuf Mir Date= 24-May-2021 Method name: deletePackage
	 * Parameters: packageId Return Type: Package object
	 *
	 **/
	public Package deletePackage(int packageId) throws PackageNotFoundException {

		try {
			Optional<Package> opt = packageRepository.findById(packageId);
			if (opt.isPresent()) {
				packageRepository.deleteById(packageId);
				return opt.get();

			} else {
				throw new PackageNotFoundException("Package not found in delete");
			}

		} catch (Exception e) {

			throw new PackageNotFoundException("Package not found in delete");

		}

	}

	@Override
	/*
	 * Author= Iflak Yousuf Mir Date= 24-May-2021 Method name: searchPackage
	 * Parameters: packageId Return Type: Package object
	 *
	 **/
	public Package searchPackage(int packageId) throws PackageNotFoundException {
		try {
			Optional<Package> opt = packageRepository.findById(packageId);
			if (opt.isPresent()) {
				return opt.get();
			} else {
				throw new PackageNotFoundException("Package Not Found in search");
			}

		} catch (Exception e) {

			throw new PackageNotFoundException("Package Not Found in search");

		}

	}

	@Override
	/*
	 * Author= Iflak Yousuf Mir Date= 24-May-2021 Method name: deletePackage
	 * Parameters: none Return Type: List of Package objects
	 *
	 **/
	public List<Package> viewAllPackages( Optional<String> sortby, Optional<String> sort) {
		List<Package> list = null;
		try {
			list = packageRepository.findAll();
			if (sortby.isPresent()) {
			 	 list=Sorting(list, sortby.get(), sort);
			 
			}
		} catch (Exception e) {
			log.error("View all Exception:", e);

		}
       
		return list;
	}

	@Override
	public List<Package> viewByRoute(String from, String to, Optional<String> sortBy, Optional<String> sort,String d ) throws PackageNotFoundException {
		List<Package> list = null;
		try {
			SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat myFormat = new SimpleDateFormat("yy-MM-dd");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
			LocalDate dt = LocalDate.parse(myFormat.format(fromUser.parse(d)), formatter);
			System.out.println("Seconf="+dt);
			list = packageRepository.findByRoute(from, to,dt);
			if (list.isEmpty()) {
				throw new PackageNotFoundException("Package is not available for this route");
			} 
				return list;
			
		}catch(

	Exception e)
	{   
			e.printStackTrace();
		throw new PackageNotFoundException("Package Not Found with given Route");
	}
	}

	@Override
	public Package searchPackagebyName(String name) throws PackageNotFoundException {
		try {
			Optional<Package> opt = packageRepository.findByName(name);
			if (opt.isPresent()) {
				return opt.get();
			} else {
				throw new PackageNotFoundException("Package Not Found in search by Name");
			}

		} catch (Exception e) {

			throw new PackageNotFoundException("Package Not Found in search by Name");

		}
	}

	@Override
	public Package deletePackagebyName(String name) throws PackageNotFoundException {

		try {
			Optional<Package> opt = packageRepository.findByName(name);
			if (opt.isPresent()) {
				packageRepository.deleteById(opt.get().getPackageId());
				return opt.get();

			} else {
				throw new PackageNotFoundException("Package name not found in delete");
			}

		} catch (Exception e) {

			throw new PackageNotFoundException("Package not found in delete");

		}

	}

	public List<Package> Sorting(List<Package> packageList, String Sortby, Optional<String> sort) {
		if (sort.isPresent()) {
			if (Sortby.equals("Asc")) {
				Collections.sort(packageList, new PackageSortingConfiguration().new SortbyPriceAsc());
			} else {
				Collections.sort(packageList, new PackageSortingConfiguration().new SortbyPriceDes());
			}
		} else {
			if (sort.get().equals("name")) {
				if (Sortby.equals("Asc")) {
					Collections.sort(packageList, new PackageSortingConfiguration().new SortbynameAsc());
				} else {
					Collections.sort(packageList, new PackageSortingConfiguration().new SortbynameDes());
				}
			}
			if (sort.get().equals("arrtime")) {
				if (Sortby.equals("Asc")) {
					Collections.sort(packageList, new PackageSortingConfiguration().new SortbyArrTimeAsc());
				} else {
					Collections.sort(packageList, new PackageSortingConfiguration().new SortbyArrTimeDes());
				}
			}
		}
		return packageList;
	}

}
