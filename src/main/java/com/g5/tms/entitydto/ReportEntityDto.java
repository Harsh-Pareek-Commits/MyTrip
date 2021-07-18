package com.g5.tms.entitydto;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.g5.tms.dto.BookingDto;

public class ReportEntityDto {
	private int reportId;
	@NotEmpty(message = "Report name cannot be left blank or null")
	private String rptName;
	@NotEmpty(message = "Report type cannot be left blank or null")
	private String rptType; 
	private Set<BookingEntityDto> allbookings;
	public String getRptName() {
		return rptName;
	}
	public void setRptName(String rptName) {
		this.rptName = rptName;
	}
	public String getRptType() {
		return rptType;
	}
	public void setRptType(String rptType) {
		this.rptType = rptType;
	}
	
	
	public Set<BookingEntityDto> getAllbookings() {
		return allbookings;
	}
	public void setAllbookings(Set<BookingEntityDto> allbookings) {
		this.allbookings = allbookings;
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	@Override
	public String toString() {
		return "ReportEntityDto [reportId=" + reportId + ", rptName=" + rptName + ", rptType=" + rptType
				+ ", allbookings=" + allbookings + "]";
	}
	
}
