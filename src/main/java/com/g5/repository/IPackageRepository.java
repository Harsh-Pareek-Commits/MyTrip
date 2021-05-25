package com.g5.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.g5.entities.Package;



public interface IPackageRepository extends JpaRepository<Package, Integer> {
	
	

}
