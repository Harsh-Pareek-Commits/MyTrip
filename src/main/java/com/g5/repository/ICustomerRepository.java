package com.g5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g5.entities.Customer;
import com.g5.exceptions.CustomerNotFoundException;
import com.g5.exceptions.PackageNotFoundException;
import com.g5.exceptions.RouteNotFoundException;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
