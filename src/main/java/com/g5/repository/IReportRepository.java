package com.g5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.entities.Report;
import com.g5.exceptions.ReportNotFoundException;
@Repository
public interface IReportRepository extends JpaRepository<Report, Integer>{
	
	
	
	

}
