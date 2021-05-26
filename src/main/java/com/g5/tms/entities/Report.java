package com.g5.tms.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
@Entity
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reportId;
	@Column
	private String reportName;
	@Column
	private String reportType; 
	@OneToMany(cascade = CascadeType.ALL)
	  @JoinTable(name = "Report_booking", joinColumns = @JoinColumn(name = "reportId"),
	  inverseJoinColumns = @JoinColumn(name = "bookingId"))
	private Set<Booking> allBookings;
	
	public Report() {
		super();
		// TODO Auto-generated constructor stub
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
