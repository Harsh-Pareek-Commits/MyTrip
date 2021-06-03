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
	IPackageRepository package_repo;

	@Override
	@Transactional
	public Package addPackage(Package pack) {
		try {
			package_repo.save(pack);
		} catch (Exception e) {
			log.error("Exception:", e);
		}
		return pack;
	}

	@Override
	@Transactional
	public Package deletePackage(int packageId) throws PackageNotFoundException {
		Optional<Package> opt = null;
		try {
			opt = package_repo.findById(packageId);
			if (opt.isPresent()) {
				package_repo.deleteById(packageId);

			} else {
				throw new PackageNotFoundException("Package not found in delete");
			}

		} catch (Exception e) {
			log.error("Exception:", e);
			throw new PackageNotFoundException("Package not found in delete");

		}
		return opt.get();
	}

	@Override
	public Package searchPackage(int packageId) throws PackageNotFoundException {
		try {
			Optional<Package> opt = package_repo.findById(packageId);
			if (opt.isPresent()) {
				return opt.get();
			} else {
				throw new PackageNotFoundException("Package Not Found in search");
			}

		} catch (Exception e) {
			log.error("Exception:", e);
			throw new PackageNotFoundException("Package Not Found in search");

		}

	}

	@Override
	public List<Package> viewAllPackages() {
		List<Package> list = null;
		try {
			list = package_repo.findAll();
		} catch (Exception e) {
			log.error("Exception:", e);

		}

		return list;
	}

}
