package com.g5.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.g5.tms.entities.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
@Query("select c from Customer c where c.userId =(Select b.userId from Booking b where b.pack.packageId=:packageId)")
List<Customer> findByPackageId(@Param("packageId") Integer packageId);
@Query("select c from Customer c where c.userId in(Select b.userId from Booking b where b.pack.packageId in ( select p.packageId from Package p where p.route.routeId in(Select r.routeId from Route r where r.routeId=:routeId)))")
List<Customer> findByRouteId(@Param("routeId") Integer routeId);

}
