package com.g5.tms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import lombok.Data;

@Data
public class BusDto {

	private int busId;

	private  String busType;
	
	private  String busNumber;
	
	
	private TravelsDto travel;

	public TravelsDto getTravel() {
		return travel;
	}

	public void setTravel(TravelsDto travel) {
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

	@Override
	public String toString() {
		return "BusDto [busId=" + busId + ", busType=" + busType + ", busNumber=" + busNumber + "]";
	}
	
}
	
	