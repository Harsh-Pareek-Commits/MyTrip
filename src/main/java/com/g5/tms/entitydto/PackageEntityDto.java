package com.g5.tms.entitydto;



import javax.validation.Valid;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.g5.tms.entities.Hotel;
import com.g5.tms.entities.Route;


public class PackageEntityDto {

	private int packageId;
	@NotEmpty(message = "Package name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Package Name")
	private String packName;
	@Size(min = 10, max = 50, message 
		    = "Package Description must be between 10 and 50 characters")
	private String packDescription;
	@NotEmpty(message = "Package Type cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Package Type")
	private String packType;
	@Positive
	@Min(0)
	private double packCost;
	@Valid
	private RouteEntityDto route;
	@Valid
	private Hotel hotel;
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public String getPackDescription() {
		return packDescription;
	}
	public void setPackDescription(String packDescription) {
		this.packDescription = packDescription;
	}
	public String getPackType() {
		return packType;
	}
	public void setPackType(String packType) {
		this.packType = packType;
	}
	public double getPackCost() {
		return packCost;
	}
	public void setPackCost(double packCost) {
		this.packCost = packCost;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
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
		return "PackageEntityDto [packageId=" + packageId + ", packName=" + packName + ", packDescription="
				+ packDescription + ", packType=" + packType + ", packCost=" + packCost + ", route=" + route
				+ ", hotel=" + hotel + "]";
	}
	

}
