package com.g5.tms.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Package {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int packageId;
	
	@ApiModelProperty(name = "PackageName", value = "Cannot be empty, holds min of 2 max of 15 characters")
	@Column
	@NotEmpty(message = "Package name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Package Name")
	private String packageName;
	
	@ApiModelProperty(name = "PackageDescription", value = "Holds min of 10 max of 50 characters")
	@Column
	@Size(min = 10, max = 50, message = "Package Description must be between 10 and 50 characters")
	private String packageDescription;
	
	@ApiModelProperty(name = "PackageType", value = "Cannot be empty, holds min of 2 max of 15 characters")
	@Column
	@NotEmpty(message = "Package Type cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Package Type")
	private String packageType;
	
	@ApiModelProperty(name = "PackageCost", value = "Contains positive value")
	@Column
	@Positive
	@Min(0)
	private double packageCost;
	
	@ApiModelProperty(name = "Route", value = "Contains route information")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Route_info", referencedColumnName = "routeId")
	@Valid
	private Route route;
	
	@ApiModelProperty(name = "Hotel", value = "Contains hotel information")

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "Hotel_info", referencedColumnName = "hotelId")	
	 @Valid
	private List<Hotel> hotel;

	public Package() {
		super();

	}
	

	public Package(int packageId,
			String packageName,
			String packageDescription,
			 String packageType,
		 double packageCost,  Route route,  List<Hotel> hotel) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageType = packageType;
		this.packageCost = packageCost;
		this.route = route;
		this.hotel = hotel;
	}


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

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<Hotel> getHotel() {
		return hotel;
	}

	public void setHotel(List<Hotel> hotel) {
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
