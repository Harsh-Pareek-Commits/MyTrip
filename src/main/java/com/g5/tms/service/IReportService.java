package com.g5.tms.service;

import java.util.List;

import com.g5.tms.entities.Report;
import com.g5.tms.exceptions.ReportNotFoundException;

public interface IReportService {
	
	
		public Report  addReport(Report report);
		public Report  deleteReport(int reportId) throws ReportNotFoundException;
		public Report  viewReport(int reportId) throws ReportNotFoundException;
		public List<Report>  viewAllReports();
		
	
	
	

}
