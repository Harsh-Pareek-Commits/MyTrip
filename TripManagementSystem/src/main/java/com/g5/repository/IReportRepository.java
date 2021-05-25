package com.g5.repository;

import com.g5.entities.Report;
import com.g5.exceptions.ReportNotFoundException;

public interface IReportRepository {
	
	
		public Report  addReport(Report report);
		public Report  deleteReport(int reportId) throws ReportNotFoundException;
		public Report  viewReport(int reportId) throws ReportNotFoundException;
		public Report  viewAllReports();
		
	
	
	

}
