package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.g5.tms.dto.ReportDto;
import com.g5.tms.entities.Report;
import com.g5.tms.entityDto.ReportEntityDto;
import com.g5.tms.exceptions.ReportNotFoundException;
import com.g5.tms.service.IReportService;

@RestController
@RequestMapping("/report")
public class ReportController {
	@Autowired
    IReportService reportService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/add")
	public ResponseEntity<ReportDto> addFeedback(@RequestBody @Valid ReportEntityDto requestreport) {

		Report actualreport = modelMapper.map(requestreport, Report.class);
		ReportDto responsereport = modelMapper.map(this.reportService.addReport(actualreport), ReportDto.class);
		return new ResponseEntity<>(responsereport, HttpStatus.OK);
	}
	/*public Report addReport(@RequestBody @Valid Report repo) {
		this.reportService.addReport(repo);
		return repo;
	}*/
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ReportDto> deleteReport(@PathVariable int ReportId) throws ReportNotFoundException {
		ReportDto responsereport = modelMapper.map(this.reportService.deleteReport(ReportId), ReportDto.class);
		if (responsereport != null) {
			return new ResponseEntity<>(responsereport, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsereport, HttpStatus.BAD_REQUEST);
		}
		 
	}
	/*
	public Report deleteReport(@PathVariable int id) throws ReportNotFoundException {
   	 Report repo = this.reportService.deleteReport(id);
		return repo;
	}*/
	
	@GetMapping("/view/{repoid}")
	
	public ResponseEntity<ReportDto> viewReportbyId(@PathVariable int reportid) throws ReportNotFoundException {

		ReportDto responsereport = modelMapper.map(this.reportService.viewReport(reportid), ReportDto.class);
		if (responsereport != null) {
			return new ResponseEntity<>(responsereport, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsereport, HttpStatus.BAD_REQUEST);
		}
	}
	/*public Report viewReport(@PathVariable int repoid) throws ReportNotFoundException {
    	Report repo;
    	repo=this.reportService.viewReport(repoid);
		return repo;
	}*/
	
	@GetMapping("/all")
	public ResponseEntity<List<ReportDto>> viewAllReports() {
	       
        List<Report> reportList = this.reportService.viewAllReports();
		List<ReportDto> ReportDtoList = new ArrayList<>();
		for (Report r : reportList) {
			ReportDto reportdto = modelMapper.map(r, ReportDto.class);
			ReportDtoList.add(reportdto);
		}
		if (!(ReportDtoList.isEmpty())) {
			return new ResponseEntity<>(ReportDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ReportDtoList, HttpStatus.BAD_REQUEST);
		}
	}
	
    /*public List<@NotBlank Report> viewReport(){
	    return reportService.viewAllReports();
	}*/
}
