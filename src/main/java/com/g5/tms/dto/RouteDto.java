package com.g5.tms.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class RouteDto {
	

	private int routeId;
	private String  routeFrom;
	private String  routeTo;
	private  List<BusDto> buses;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private  LocalDateTime  departureTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private  LocalDateTime   arrivalTime;
	
	private  double duration;
	private String pickupPoint;
	private  double fare;
	public int getRouteId() {
		return routeId;
	}
	

	public double getDuration() {
		return duration;
	}



	public void setDuration(double duration) {
		this.duration = duration;
	}



	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getRouteFrom() {
		return routeFrom;
	}
	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}
	public String getRouteTo() {
		return routeTo;
	}
	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}
	public List<BusDto> getBuses() {
		return buses;
	}
	public void setBuses(List<BusDto> buses) {
		this.buses = buses;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public String getPickupPoint() {
		return pickupPoint;
	}
	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	@Override
	public String toString() {
		return "RouteDto [routeId=" + routeId + ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", buses=" + buses
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", duration=" + duration
				+ ", pickupPoint=" + pickupPoint + ", fare=" + fare + "]";
	}
	

}
