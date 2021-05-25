package com.g5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.g5.entities.Report;
import com.g5.exceptions.ReportNotFoundException;
import com.g5.repository.IReportRepository;

public class IReportServiceImpl implements IReportService {
	
	@Autowired
	IReportRepository repository;

	@Override
	@Transactional
	public Report addReport(Report report) {
		// TODO Auto-generated method stub
		try {
			repository.save(report);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return report;
	}

	@Override
	public Report deleteReport(int reportId) throws ReportNotFoundException {
		// TODO Auto-generated method stub
	    Report report = new Report();
	    report.setReportId(reportId);
	    try {
	    	repository.deleteById(reportId);
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    	throw new ReportNotFoundException("Report not found!");
	    }
		return report;
	}

	@Override
	public Report viewReport(int reportId) throws ReportNotFoundException {
		// TODO Auto-generated method stub
		try {
			return repository.findById(reportId).get();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ReportNotFoundException("Report not found!");
		}
		 
	}

	@Override
	public List<Report> viewAllReports() {
		// TODO Auto-generated method stub
		List<Report> reportList = null;
		try {
			reportList = repository.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return reportList;
	}

}
