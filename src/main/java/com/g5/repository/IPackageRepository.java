package com.g5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.g5.entities.Package;

@Repository
public interface IPackageRepository extends JpaRepository<Package, Integer> {

	@Query("select p from Package where p.route.routeId in(Select r.routeId from Route where r.routeId=:route_Id)")
	List<Package> findByRouteId(int route_id);

}
