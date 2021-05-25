package com.g5.service;

import com.g5.entities.Report;
import com.g5.exceptions.ReportNotFoundException;

public interface IReportService {
	
	
		public Report  addReport(Report report);
		public Report  deleteReport(int reportId) throws ReportNotFoundException;
		public Report  viewReport(int reportId) throws ReportNotFoundException;
		public Report  viewAllReports();
		
	
	
	

}
