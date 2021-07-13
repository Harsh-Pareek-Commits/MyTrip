package com.g5.tms.dto;

import lombok.Data;

@Data
public class BusDto {

	private int busId;

	private  String busType;
	
	private  String busNumber;
	
	private  String capacity;
	private TravelsDto travel;
	
	
	public BusDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BusDto(int busId, String busType, String busNumber, String capacity, TravelsDto travel) {
		super();
		this.busId = busId;
		this.busType = busType;
		this.busNumber = busNumber;
		this.capacity = capacity;
		this.travel = travel;
	}

	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public TravelsDto getTravel() {
		return travel;
	}
	public void setTravel(TravelsDto travel) {
		this.travel = travel;
	}

	
	
}
	
	