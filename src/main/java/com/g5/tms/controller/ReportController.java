package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.g5.tms.dto.ReportDto;
import com.g5.tms.entities.Report;
import com.g5.tms.entitydto.ReportEntityDto;
import com.g5.tms.exceptions.ReportNotFoundException;
import com.g5.tms.service.IReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/report")
@Api("Travel Management Application")
public class ReportController {
	@Autowired
    IReportService reportService;
	
	@Autowired
	private ModelMapper modelMapper;
	/*
	 *Author= Jaydeep Maity
	 *Date= 26-May-2021
	 *Method name: addReport
	 *Parameters: ReportEntityDto object
	 *Return Type: ReportDto object
	 *
	 **/
	@ApiOperation(value = "Report Post mapping to add report", response = Report.class)
	@PostMapping("/add")
	public ResponseEntity<ReportDto> addReport(@RequestBody @Valid ReportEntityDto requestreport) {
	Report actualreport = modelMapper.map(requestreport, Report.class);
		ReportDto responsereport = modelMapper.map(this.reportService.addReport(actualreport), ReportDto.class);
		return new ResponseEntity<>(responsereport, HttpStatus.OK);
	}
	
	/*
	 *Author= Jaydeep Maity
	 *Date= 26-May-2021
	 *Method name: deleteReport
	 *Parameters: Report id
	 *Return Type: ReportDto object
	 *
	 **/
	
	@ApiOperation(value = "Report Delete mapping to delete report", response = Report.class)
	@DeleteMapping("/delete/{reportId}")
	public ResponseEntity<ReportDto> deleteReport(@PathVariable int reportId) throws ReportNotFoundException {
		ReportDto responsereport = modelMapper.map(this.reportService.deleteReport(reportId), ReportDto.class);
		
		if (responsereport != null) {
			return new ResponseEntity<>(responsereport, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsereport, HttpStatus.BAD_REQUEST);
		}
		 
	}
	
	/*
	 *Author= Jaydeep Maity
	 *Date= 26-May-2021
	 *Method name: viewReportbyId
	 *Parameters: Report id
	 *Return Type: ReportDto object
	 *
	 **/
	
	
	@ApiOperation(value = "Report Get mapping to fetch report by report id", response = Report.class)
	@GetMapping("/view/{reportid}")
	public ResponseEntity<ReportDto> viewReportbyId(@PathVariable int reportid) throws ReportNotFoundException {
	ReportDto responsereport = modelMapper.map(this.reportService.viewReport(reportid), ReportDto.class);
		if (responsereport != null) {
			return new ResponseEntity<>(responsereport, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsereport, HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	 *Author= Jaydeep Maity
	 *Date= 26-May-2021
	 *Method name: viewAllReports
	 *Return Type: ReportDto object list
	 *
	 **/
	
	
	@ApiOperation(value = "Report Get mapping to fetch all reports", response = List.class)
	@GetMapping("/all")
	public ResponseEntity<List<ReportDto>> viewAllReports() {
	       
		 List<Report> reportList = this.reportService.viewAllReports();
		List<ReportDto> reportDtoList = new ArrayList<>();
		for (Report r : reportList) {
			ReportDto reportdto = modelMapper.map(r, ReportDto.class);
			reportDtoList.add(reportdto);
		}
		if (!(reportDtoList.isEmpty())) {
			return new ResponseEntity<>(reportDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(reportDtoList, HttpStatus.BAD_REQUEST);
		}
	}
	
  
}
