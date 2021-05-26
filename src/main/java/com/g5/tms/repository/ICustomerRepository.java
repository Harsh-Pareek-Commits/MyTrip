package com.g5.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.g5.tms.entities.Customer;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.exceptions.RouteNotFoundException;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
@Query("select c from Customer where c.userId in(Select b.userId from Booking where b.pack.packageId=:package_id)")
List<Customer> findByPackageId(int package_id);

}
