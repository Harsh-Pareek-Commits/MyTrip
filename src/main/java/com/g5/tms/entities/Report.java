package com.g5.tms.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.JoinColumn;
@Entity
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reportId;
	
	@ApiModelProperty(name = "ReportName", value = "Cannot be empty, holds min of 2 and max of 15 characters")
	@Column
	@NotEmpty(message = "Report name cannot be left blank or null")
	private String reportName;
	
	@ApiModelProperty(name = "ReportType", value = "Cannot be empty, holds min of 2 and max of 15 characters")
	@Column
	@NotEmpty(message = "Report type cannot be left blank or null")
	private String reportType; 
	
	@ApiModelProperty(name = "Bookings", value = "Contails booking details")
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookingId", referencedColumnName = "bookingId")
	private Set<Booking> allBookings;
	
	public Report() {
		super();

	}
	public Report(int reportId, String reportName, String reportType, Set<Booking> allBookings) {
		super();
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportType = reportType;
		this.allBookings = allBookings;
	}
	
	/**
	 * @return the reportId
	 */
	public int getReportId() {
		return reportId;
	}
	/**
	 * @param reportId the reportId to set
	 */
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	/**
	 * @return the reportName
	 */
	public String getReportName() {
		return reportName;
	}
	/**
	 * @param reportName the reportName to set
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	/**
	 * @return the reportType
	 */
	public String getReportType() {
		return reportType;
	}
	/**
	 * @param reportType the reportType to set
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	/**
	 * @return the allBookings
	 */
	public Set<Booking> getAllBookings() {
		return allBookings;
	}
	/**
	 * @param allBookings the allBookings to set
	 */
	public void setAllBookings(Set<Booking> allBookings) {
		this.allBookings = allBookings;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allBookings == null) ? 0 : allBookings.hashCode());
		result = prime * result + reportId;
		result = prime * result + ((reportName == null) ? 0 : reportName.hashCode());
		result = prime * result + ((reportType == null) ? 0 : reportType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (allBookings == null) {
			if (other.allBookings != null)
				return false;
		} else if (!allBookings.equals(other.allBookings))
			return false;
		if (reportId != other.reportId)
			return false;
		if (reportName == null) {
			if (other.reportName != null)
				return false;
		} else if (!reportName.equals(other.reportName))
			return false;
		if (reportType == null) {
			if (other.reportType != null)
				return false;
		} else if (!reportType.equals(other.reportType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", reportName=" + reportName + ", reportType=" + reportType
				+ ", allBookings=" + allBookings + "]";
	}
	
	

}
