package com.g5.tms.entityDto;

import java.util.Set;

import com.g5.tms.entities.Booking;

public class ReportEntityDto {
	
	private int reportId;
	private String reportName;
	private String reportType; 
	private Set<BookingEntityDto> allBookings;
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
	public Set<BookingEntityDto> getAllBookings() {
		return allBookings;
	}
	public void setAllBookings(Set<BookingEntityDto> allBookings) {
		this.allBookings = allBookings;
	}
	@Override
	public String toString() {
		return "ReportEntityDto [reportId=" + reportId + ", reportName=" + reportName + ", reportType=" + reportType
				+ "]";
	}
	

}
