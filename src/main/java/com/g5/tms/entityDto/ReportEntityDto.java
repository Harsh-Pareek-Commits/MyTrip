package com.g5.tms.entityDto;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.g5.tms.dto.BookingDto;


public class ReportEntityDto {
	
	private int reportId;
	@NotEmpty(message = "Report name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid report Name")
	private String reportName;
	@NotEmpty(message = "Report type cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Report Name")
	private String reportType; 
	@Valid
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
		return "ReportEntityDto [reportId=" + reportId + ", reportName=" + reportName + ", reportType=" + reportType
				+ "]";
	}
	

}
