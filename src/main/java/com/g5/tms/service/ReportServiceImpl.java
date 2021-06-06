package com.g5.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.tms.entities.Report;
import com.g5.tms.exceptions.ReportNotFoundException;
import com.g5.tms.repository.IReportRepository;
@Service
public class ReportServiceImpl implements IReportService {
	Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);
	@Autowired
	IReportRepository reportRepository;

	@Override
	@Transactional
	public Report addReport(Report report) {
		
		try {
			reportRepository.save(report);
		}
		catch(Exception e)
		{
			log.error("Add Report Exception:", e);
		}
		return report;
	}

	@Override
	@Transactional
	public Report deleteReport(int reportId) throws ReportNotFoundException {
		
		try {
			Optional<Report>opt= reportRepository.findById(reportId);
		    if(opt.isPresent()) {
	    	reportRepository.deleteById(reportId);
	    	
	    	return opt.get();
		    		    }
		    else {
		    	throw new ReportNotFoundException("Report not found in delete!");
		    }
	    }
	    catch (Exception e)
	    {
	    	
	    	throw new ReportNotFoundException("Report not found in delete!");
	    }
		
	}

	@Override
	public Report viewReport(int reportId) throws ReportNotFoundException {
	
		try {
			Optional<Report>opt= reportRepository.findById(reportId);
			if(opt.isPresent()) {
			 return opt.get();
			}else {
				throw new ReportNotFoundException("Report not found in view report!");
			}
		}
		catch(Exception e) {
			
			throw new ReportNotFoundException("Report not found in view report!");
		}
		 
	}

	@Override
	public List<Report> viewAllReports() {
				List<Report> reportList = null;
		try {
			reportList = reportRepository.findAll();
		}
		catch(Exception e) {
			log.error("View all reports Exception:", e);
		}
		
		return reportList;
	}

}
