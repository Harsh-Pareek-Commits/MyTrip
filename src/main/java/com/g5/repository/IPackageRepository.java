package com.g5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g5.exceptions.PackageNotFoundException;


public interface IPackageRepository extends JpaRepository<Package, Integer> {
	
	

}
