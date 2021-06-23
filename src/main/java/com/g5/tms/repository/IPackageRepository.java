package com.g5.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.query.Param;

import com.g5.tms.entities.Customer;
import com.g5.tms.entities.Package;
import java.util.Optional;
@Repository
public interface IPackageRepository extends JpaRepository<Package, Integer> {
	
	@Query("select p from Package p where p.route.routeFrom=:routeFrom and p.route.routeTo=:routeTo ")
	List<Package> findByRoute(@Param("routeFrom") String routeFrom,@Param("routeTo") String routeTo);
	
	@Query("select p from Package p where p.packageName=:packageName")
	Optional<Package> findByName(@Param("packageName") String packageName);
}
