package com.g5.tms.dto;

import java.util.Set;
public class ReportDto {
	
	private int reportId;
	private String reportName;
	private String reportType; 
	private Set<BookingDto> allBookings;
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public Set<BookingDto> getAllBookings() {
		return allBookings;
	}
	public void setAllBookings(Set<BookingDto> allBookings) {
		this.allBookings = allBookings;
	}
	@Override
	public String toString() {
		return "ReportDto [reportId=" + reportId + ", reportName=" + reportName + ", reportType=" + reportType + "]";
	}
	
}
