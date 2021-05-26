package com.g5.service;

import com.g5.entities.Package;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.exceptions.PackageNotFoundException;
import com.g5.repository.IPackageRepository;
@Service
public class PackageServiceImpl implements IPackageService {
	@Autowired
	IPackageRepository package_repo;

	@Override
	@Transactional
	public Package addPackage(Package pack) {
		try {
			package_repo.save(pack);

		} catch (Exception e) {
			e.getStackTrace();
		}
	
		return pack;
	}

	@Override
	@Transactional
	public Package deletePackage(int packageId) throws PackageNotFoundException {
		Optional<Package> opt=null;
		try {
			opt = package_repo.findById(packageId);
			package_repo.deleteById(packageId);
			return opt.get();

		} catch (Exception e) {
			e.getStackTrace();
			throw new PackageNotFoundException("Package not found in delete");
			
		}

	}

	@Override
	public Package searchPackage(int packageId) throws PackageNotFoundException {
		try {
			Package p = package_repo.findById(packageId).get();
			return p;

		} catch (Exception e) {
			e.getStackTrace();
			throw new PackageNotFoundException("Package Not Found in search");
			
		}

	}

	@Override
	public List<Package> viewAllPackages() {
		List<Package> list = null;
		try {
			list = package_repo.findAll();
		} catch (Exception e) {
			e.getStackTrace();
			
		}

		return list;
	}

}
