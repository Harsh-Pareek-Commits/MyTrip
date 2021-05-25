package com.g5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g5.entities.Report;
import com.g5.exceptions.ReportNotFoundException;

public interface IReportRepository extends JpaRepository<Report, Integer>{
	
	
	
	

}
