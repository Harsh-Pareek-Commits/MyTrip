package com.g5.tms.entityDto;


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

import com.g5.tms.entities.Hotel;


public class PackageEntityDto {

	
	private int packageId;
	@NotEmpty(message = "Package name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Package Name")
	private String packageName;
	@Size(min = 10, max = 50, message 
		    = "Package Description must be between 10 and 50 characters")
	private String packageDescription;
	@NotEmpty(message = "Package Type cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Package Type")
	private String packageType;
	@Positive
	@Min(0)
	private double packageCost;
	@Valid
	private RouteEntityDto route;
	@Valid
	private Hotel hotel;

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}

	public RouteEntityDto getRoute() {
		return route;
	}

	public void setRoute(RouteEntityDto route) {
		this.route = route;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "PackageEntityDto [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", packageType=" + packageType + ", packageCost=" + packageCost + ", route="
				+ route + ", hotel=" + hotel + "]";
	}

	
}
