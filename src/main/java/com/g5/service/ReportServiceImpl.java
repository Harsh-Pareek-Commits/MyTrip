package com.g5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.entities.Report;
import com.g5.exceptions.ReportNotFoundException;
import com.g5.repository.IReportRepository;
@Service
public class ReportServiceImpl implements IReportService {
	
	@Autowired
	IReportRepository report_repository;

	@Override
	@Transactional
	public Report addReport(Report report) {
		// TODO Auto-generated method stub
		try {
			report_repository.save(report);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return report;
	}

	@Override
	@Transactional
	public Report deleteReport(int reportId) throws ReportNotFoundException {
		Optional<Report>opt=null;
		try {
	    	opt = report_repository.findById(reportId);
		    
	    	report_repository.deleteById(reportId);
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    	throw new ReportNotFoundException("Report not found!");
	    }
		return opt.get();
	}

	@Override
	public Report viewReport(int reportId) throws ReportNotFoundException {
		// TODO Auto-generated method stub
		try {
			return report_repository.findById(reportId).get();
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
			reportList = report_repository.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return reportList;
	}

}
