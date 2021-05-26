package com.g5.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.g5.tms.entities.Package;

@Repository
public interface IPackageRepository extends JpaRepository<Package, Integer> {

	@Query("select p from Package p where p.route.routeId in(Select r.routeId from Route r where r.routeId=:routeId)")
	List<Package> findByRouteId(@Param("routeId") Integer routeId);

}
