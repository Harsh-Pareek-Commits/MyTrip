package com.g5.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.query.Param;
import com.g5.tms.entities.Package;

@Repository
public interface IPackageRepository extends JpaRepository<Package, Integer> {


}
