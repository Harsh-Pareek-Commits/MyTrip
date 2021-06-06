package com.g5.tms.dto;




import lombok.Data;

@Data
public class PackageDto {

	private int packageId;
	
	private String packageName;
	
	private String packageDescription;
	
	private String packageType;
	
	private double packageCost;
	private RouteDto route;
	
	private HotelDto hotel;


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

	public RouteDto getRoute() {
		return route;
	}

	

	public void setRoute(RouteDto route) {
		this.route = route;
	}

	public HotelDto getHotel() {
		return hotel;
	}

	public void setHotel(HotelDto hotel) {
		this.hotel = hotel;
	}
	
	@Override
	public String toString() {
		return "PackageDto [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", packageType=" + packageType + ", packageCost=" + packageCost + ", hotel="
				+ hotel + "]";
	}
	
}
