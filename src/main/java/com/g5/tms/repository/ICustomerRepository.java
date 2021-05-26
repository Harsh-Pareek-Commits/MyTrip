package com.g5.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.g5.tms.entities.Customer;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.exceptions.RouteNotFoundException;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
@Query("select c from Customer c where c.userId in(Select b.userId from Booking b where b.pack.packageId=:packageId)")
List<Customer> findByPackageId(@Param("packageId") Integer packageId);

}
