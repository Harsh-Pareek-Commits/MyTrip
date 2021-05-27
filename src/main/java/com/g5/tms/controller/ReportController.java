package com.g5.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.entities.Report;
import com.g5.tms.exceptions.ReportNotFoundException;
import com.g5.tms.service.IReportService;

@RestController
@RequestMapping("/report")
public class ReportController {
	@Autowired
    IReportService report_service;
	@PostMapping("/add")
	public Report addReport(@RequestBody Report repo) {
		this.report_service.addReport(repo);
		return repo;
	}
	
	@DeleteMapping("/delete/{id}")
	public Report deleteReport(@RequestBody int id) throws ReportNotFoundException {
   	 Report repo = this.report_service.deleteReport(id);
		return repo;
	}
	
	@GetMapping("/view/{repoid}")
	public Report viewReport(@PathVariable int repoid) throws ReportNotFoundException {
    	Report repo;
    	repo=this.report_service.viewReport(repoid);
		return repo;
	}
	
	@GetMapping("/all")
    public List<Report> viewReport(){
	    return report_service.viewAllReports();
	}
}
