package com.g5.tms.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Package {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int packageId;
	@Column
	@NotEmpty(message = "Package name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Package Name")
	private String packageName;
	@Column
	@Size(min = 10, max = 50, message 
    = "Package Description must be between 10 and 50 characters")
	private String packageDescription;
	@Column
	@NotEmpty(message = "Package Type cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Package Type")
	private String packageType;
	@Column
	@Positive
	@Min(0)
	private double packageCost;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Route_info", referencedColumnName = "routeId")
	@Valid
	private Route route;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "Hotel_info", referencedColumnName = "hotelId")
	@Valid
	private Hotel hotel;

	public Package() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Package(int packageId, String packageName, String packageDescription, String packageType, double packageCost,
			Route route, Hotel hotel) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageType = packageType;
		this.packageCost = packageCost;
		this.route = route;
		this.hotel = hotel;
	}

	/**
	 * @return the packageId
	 */
	public int getPackageId() {
		return packageId;
	}

	/**
	 * @param packageId the packageId to set
	 */
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	/**
	 * @return the packageName
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * @param packageName the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * @return the packageDescription
	 */
	public String getPackageDescription() {
		return packageDescription;
	}

	/**
	 * @param packageDescription the packageDescription to set
	 */
	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	/**
	 * @return the packageType
	 */
	public String getPackageType() {
		return packageType;
	}

	/**
	 * @param packageType the packageType to set
	 */
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	/**
	 * @return the packageCost
	 */
	public double getPackageCost() {
		return packageCost;
	}

	/**
	 * @param packageCost the packageCost to set
	 */
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}

	/**
	 * @return the route
	 */
	public Route getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(Route route) {
		this.route = route;
	}

	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + packageId;
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
		Package other = (Package) obj;
		if (packageId != other.packageId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", packageType=" + packageType + ", packageCost=" + packageCost + ", route="
				+ route + ", hotel=" + hotel + "]";
	}

}
