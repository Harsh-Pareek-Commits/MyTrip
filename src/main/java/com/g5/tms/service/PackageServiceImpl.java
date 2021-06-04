package com.g5.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Package addPackage(Package pack) {
		try {
			packageRepository.save(pack);
		} catch (Exception e) {
			log.error("Adding package Exception:", e);
		}
		return pack;
	}

	@Override
	@Transactional
	public Package deletePackage(int packageId) throws PackageNotFoundException {
	
		try {
			Optional<Package> opt =packageRepository.findById(packageId);
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
	public List<Package> viewAllPackages() {
		List<Package> list = null;
		try {
			list = packageRepository.findAll();
		} catch (Exception e) {
			log.error("View all Exception:", e);

		}

		return list;
	}

}
